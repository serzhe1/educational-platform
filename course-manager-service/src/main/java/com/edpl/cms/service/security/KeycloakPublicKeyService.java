package com.edpl.cms.service.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class KeycloakPublicKeyService {

    private final KeyCloakConnectionProvider keyCloakConnectionProvider;

    /**
     * Get the keycloak public key by keyId.
     * @param keyId public keyId to instanciate {@link PublicKey} for (usually in JWT Header <code>kid</code>)
     * @return corresponding PublicKey instance (RSA key type)
     * @throws Exception
     */
    @Cacheable("keycloakPublicKeys")
    public PublicKey publicKey(String keyId) throws Exception {
        Map keys = new ObjectMapper().readValue(new URL(keyCloakConnectionProvider.getOpenIdConnectCertsUrl()).openStream(), Map.class);

        Map keyInfo = ((List<Map>) keys.get("keys"))
                .stream()
                .filter(e -> keyId.equals(e.get("kid")))
                .findFirst().get();

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        String modulusBase64 = (String) keyInfo.get("n");
        String exponentBase64 = (String) keyInfo.get("e");

        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        BigInteger modulus = new BigInteger(1, urlDecoder.decode(modulusBase64));
        BigInteger publicExponent = new BigInteger(1, urlDecoder.decode(exponentBase64));

        return keyFactory.generatePublic(new RSAPublicKeySpec(modulus, publicExponent));
    }
}