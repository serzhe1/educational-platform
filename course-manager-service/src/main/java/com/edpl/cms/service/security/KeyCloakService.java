package com.edpl.cms.service.security;


import com.edpl.cms.persistence.model.security.User;
import com.edpl.cms.web.dto.security.LoginResponse;
import com.edpl.cms.web.dto.security.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.keycloak.TokenVerifier;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.security.PublicKey;

@Service
@Log4j2
@RequiredArgsConstructor
public class KeyCloakService {

    private final KeyCloakConnectionProvider keyCloakConnectionProvider;
    private final KeycloakUserDetailsService userDetailsService;
    private final KeycloakPublicKeyService keycloakPublicKeyService;
    private final RestTemplate restTemplate;

    public LoginResponse login(String username, String password) {
        log.debug("logging " + username + " from keycloak " + keyCloakConnectionProvider.getOpenIdConnectUrl());
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("client_id", keyCloakConnectionProvider.getResource());
        requestParams.add("username", username);
        requestParams.add("password", password);
        requestParams.add("grant_type", "password");
        requestParams.add("client_secret", keyCloakConnectionProvider.getClientSecret());
        requestParams.add("scope", "openid");
        AccessTokenResponse keycloakAccessToken = queryKeycloakByParams(requestParams);

        User user = getUserDetails(keycloakAccessToken.getToken());

        LoginResponse response = new LoginResponse();
        response.setToken(keycloakAccessToken);
        response.setUser(convertUserToDTO(user));

        return response;
    }

    private User getUserDetails(String token) {
        TokenVerifier<AccessToken> verifier = TokenVerifier.create(token, AccessToken.class)
                .withChecks(new TokenVerifier.RealmUrlCheck(keyCloakConnectionProvider.getRealmUrl()))
                .withChecks(TokenVerifier.IS_ACTIVE);
        AccessToken accessToken;
        try {
            PublicKey publicKey = keycloakPublicKeyService.publicKey(verifier.getHeader().getKeyId());
            accessToken = verifier.publicKey(publicKey).verify().getToken();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return userDetailsService.loadUserByToken(accessToken);
    }

    private UserDTO convertUserToDTO(User user) {
        UserDTO dto = new ModelMapper().map(user, UserDTO.class);
        dto.setRoles(user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(val -> val.replace("ROLE_", ""))
                .toList());
        return dto;
    }

    public UserDTO userRead() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)auth.getDetails();
        return convertUserToDTO(user);
    }

    public AccessTokenResponse refresh(String refreshToken) {
        try {
            MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
            requestParams.add("client_id", keyCloakConnectionProvider.getResource());
            requestParams.add("grant_type", "refresh_token");
            requestParams.add("client_secret", keyCloakConnectionProvider.getClientSecret());
            requestParams.add("refresh_token", refreshToken);

            return queryKeycloakByParams(requestParams);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            throw e;
        }
    }

    private AccessTokenResponse queryKeycloakByParams(MultiValueMap<String, String> requestParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);

        String url = keyCloakConnectionProvider.getOpenIdConnectTokenUrl();

        return getAccessTokenResponse(request, url);
    }

    private AccessTokenResponse getAccessTokenResponse(HttpEntity<MultiValueMap<String, String>> request, String url) {
        try {
            ResponseEntity<AccessTokenResponse> response = restTemplate.postForEntity(url, request, AccessTokenResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException.Unauthorized e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } catch (ResourceAccessException e) {
            log.error("KeyCloak getAccessTokenResponse: " + e.getMessage());
            ResponseEntity<AccessTokenResponse> response = restTemplate.postForEntity(url, request, AccessTokenResponse.class);
            return response.getBody();
        }
    }

    public void logout(String refreshToken) {
        try {
            MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
            requestParams.add("client_id", keyCloakConnectionProvider.getResource());
            requestParams.add("client_secret", keyCloakConnectionProvider.getClientSecret());
            requestParams.add("refresh_token", refreshToken);

            logoutUserSession(requestParams);

        } catch (Exception e) {
            log.info(e.getMessage(), e);
            throw e;
        }
    }

    private void logoutUserSession(MultiValueMap<String, String> requestParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);

        String url = keyCloakConnectionProvider.getOpenIdConnectLogoutUrl();

        restTemplate.postForEntity(url, request, Object.class);
    }
}