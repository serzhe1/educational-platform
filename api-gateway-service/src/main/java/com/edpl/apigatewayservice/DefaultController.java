package com.edpl.apigatewayservice;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
public class DefaultController {
    @GetMapping("/")
    public String index(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient, Principal principal) {
        return authorizedClient.getAccessToken().getTokenValue();
    }

    @GetMapping("/token")
    public Mono<TokenDTO> getToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
        return Mono.just(
                TokenDTO
                        .builder()
                        .value(authorizedClient.getAccessToken().getTokenValue())
                        .type(authorizedClient.getAccessToken().getTokenType().getValue())
                        .expiresAt(authorizedClient.getAccessToken().getExpiresAt())
                        .build()
        );
    }

}
