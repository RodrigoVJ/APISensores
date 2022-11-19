package com.example.demo.SecurityConfig.Keys;

import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Component
public class KeyManager {
    public RSAKey rsaKey(){
        try {
            KeyPairGenerator gerador = KeyPairGenerator.getInstance("RSA");
            gerador.initialize(2048);
            var kp = gerador.generateKeyPair();

            RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();

            return new RSAKey.Builder(publicKey)
                    .privateKey(privateKey)
                    .keyID(UUID.randomUUID().toString())
                    .build();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
