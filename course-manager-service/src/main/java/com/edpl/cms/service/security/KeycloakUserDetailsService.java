package com.edpl.cms.service.security;

import com.edpl.cms.persistence.model.security.KeyCloakUser;
import com.edpl.cms.persistence.model.security.User;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class KeycloakUserDetailsService {

    @Value("${keycloak.resource}")
    private String resource;

    public User loadUserByToken(AccessToken accessToken) {
        User user = new KeyCloakUser();
        user.setUsername(accessToken.getPreferredUsername());
        user.setDisplayName(accessToken.getName() == null || accessToken.getName().isEmpty()
                ? accessToken.getPreferredUsername()
                : accessToken.getName());
        Set<String> roles = accessToken.getResourceAccess(resource).getRoles();
        user.setAuthorities(roles.stream().map(r ->
                new SimpleGrantedAuthority("ROLE_" + r)).collect(Collectors.toSet()));

        return user;
    }

}
