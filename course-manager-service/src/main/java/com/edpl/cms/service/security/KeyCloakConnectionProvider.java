package com.edpl.cms.service.security;

import lombok.AllArgsConstructor;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@EnableConfigurationProperties(KeycloakSpringBootProperties.class)
public class KeyCloakConnectionProvider {

    public static final String PUBLIC_KEY = "publicKey";

    private KeycloakSpringBootProperties keycloakProperties;

    public String getAuthServerUrl() {
        return keycloakProperties.getAuthServerUrl();
    }

    public String getRealmUrl() {
        return getAuthServerUrl()
                + "/realms/"
                + getRealm();
    }

    public String getOpenIdConnectUrl() {
        return getRealmUrl() + "/protocol/openid-connect";
    }


    public String getOpenIdConnectUserInfoUrl() {
        return getOpenIdConnectUrl() + "/userinfo";
    }

    public String getOpenIdConnectTokenUrl() {
        return getOpenIdConnectUrl() + "/token";
    }

    public String getOpenIdConnectLogoutUrl() {
        return getOpenIdConnectUrl() + "/logout";
    }

    public String getOpenIdConnectCertsUrl() {
        return getOpenIdConnectUrl() + "/certs";
    }

    public String getRealm() {
        return keycloakProperties.getRealm();
    }

    public String getResource() {
        return keycloakProperties.getResource();
    }

    public String getClientId() {
        return getResource();
    }

    public String getClientSecret() {
        return String.valueOf(keycloakProperties.getCredentials().get("secret"));
    }

    public int getConnectionPoolSize() {
        return keycloakProperties.getConnectionPoolSize();
    }
}