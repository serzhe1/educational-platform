package com.edpl.cms.web.controller.security;


import com.edpl.cms.service.security.KeyCloakService;
import com.edpl.cms.web.dto.security.LoginRequest;
import com.edpl.cms.web.dto.security.LoginResponse;
import com.edpl.cms.web.dto.security.UserDTO;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class KeyCloakController {
    @Autowired
    private KeyCloakService keycloak;

    @PostMapping("login")
    public LoginResponse login (@RequestBody LoginRequest loginRequest) {
        return keycloak.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @GetMapping("refresh-token")
    public AccessTokenResponse refreshToken(@RequestParam String refreshToken) {
        return keycloak.refresh(refreshToken);
    }

    @GetMapping(value = "/userRead")
    public UserDTO userRead() {
        return keycloak.userRead();
    }

}
