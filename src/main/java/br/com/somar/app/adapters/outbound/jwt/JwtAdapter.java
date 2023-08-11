package br.com.somar.app.adapters.outbound.jwt;

import br.com.somar.app.application.domain.Auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtAdapter {
    @Value("${spring.security.jwt.secret}")
    private String secret;
    @Value("${spring.security.jwt.token-expiration}")
    private Integer tokenExpiration;
    @Value("${spring.security.jwt.refresh-token-expiration}")
    private Integer refreshTokenExpiration;
    private final String ISSUER = "app";

    public String generateAccessToken(Auth auth) {
        return createToken(auth, tokenExpiration);
    }
    public String generateRefreshToken(Auth auth) {
        return createToken(auth, refreshTokenExpiration);
    }
    private String createToken(Auth auth,Integer expirationToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(auth.getEmail())
                    .withExpiresAt(genExpirationDate(expirationToken))
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("error while generatong token", ex);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
         return "";
        }
    }

    private Instant genExpirationDate(Integer minute) {
        return LocalDateTime.now().plusMinutes(minute).toInstant(ZoneOffset.of("-03:00"));
    }
}
