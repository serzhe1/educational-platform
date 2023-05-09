package com.edpl.cms.web.dto.security;

import lombok.Data;
import org.keycloak.representations.AccessTokenResponse;

@Data
public class LoginResponse {
    private AccessTokenResponse token;
    private UserDTO user;
}
