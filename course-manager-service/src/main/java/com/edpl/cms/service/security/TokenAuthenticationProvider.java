package com.edpl.cms.service.security;


import com.edpl.cms.persistence.model.security.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.TokenVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.exceptions.TokenNotActiveException;
import org.keycloak.representations.AccessToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationProvider implements AuthenticationProvider {

    private final KeycloakUserDetailsService userDetailsService;
    private final KeycloakPublicKeyService keycloakPublicKeyService;
    private final KeyCloakConnectionProvider keyCloakConnectionProvider;

    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }

        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        try {
            TokenVerifier<AccessToken> verifier = TokenVerifier.create(tokenAuthentication.getToken(), AccessToken.class)
                    .withChecks(new TokenVerifier.RealmUrlCheck(keyCloakConnectionProvider.getRealmUrl()))
                    .withChecks(TokenVerifier.IS_ACTIVE);

            PublicKey publicKey = keycloakPublicKeyService.publicKey(verifier.getHeader().getKeyId());
            AccessToken accessToken = verifier.publicKey(publicKey).verify().getToken();
            User userDetails = userDetailsService.loadUserByToken(accessToken);

            // authenticate token (expired ?)
            tokenAuthentication.setDetails(userDetails);
            tokenAuthentication.setAuthorities(userDetails.getAuthorities());
            tokenAuthentication.setPrincipal(userDetails);
            tokenAuthentication.setName(userDetails.getUsername());
            tokenAuthentication.setAuthenticated(true);
        } catch (TokenNotActiveException e) {
            tokenAuthentication.setExpired(true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tokenAuthentication;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return (TokenAuthentication.class.isAssignableFrom(arg0));
    }
}
