package br.com.somar.app.adapters.outbound.jwt;

import br.com.somar.app.application.domain.Auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class JwtAdapter {
    @Value("${spring.security.jwt.secret}")
    private String secret;

    private final String ISSUER = "app";

    public String generateToken(Auth auth) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(auth.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("error while generatong token", ex);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
         return "";
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
    }
}
