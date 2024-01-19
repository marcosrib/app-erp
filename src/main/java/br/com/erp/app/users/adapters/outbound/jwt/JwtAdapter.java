package br.com.erp.app.users.adapters.outbound.jwt;

import br.com.erp.app.users.application.core.domain.Auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

@Service
public class JwtAdapter {
    private final String ISSUER = "app";
    @Value("${spring.security.jwt.secret}")
    private String secret;
    @Value("${spring.security.jwt.token-expiration}")
    private Integer tokenExpiration;
    @Value("${spring.security.jwt.refresh-token-expiration}")
    private Integer refreshTokenExpiration;

    public String generateAccessToken(Auth auth) {
        System.out.println(genExpirationDate(tokenExpiration));
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(auth.getEmail())
                    .withExpiresAt(genExpirationDate(tokenExpiration))
                    .withClaim("name", auth.getName())
                    .withClaim("email", auth.getEmail())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("error while generating access token", ex);
        }
    }

    public String generateRefreshToken(Auth auth) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(auth.getEmail())
                    .withExpiresAt(genExpirationDate(refreshTokenExpiration))
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("error while generating access token", ex);
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

    public Map<String, Claim> getClaimsFromToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }

    private Date genExpirationDate(Integer minute) {
        return Date.from(LocalDateTime.now().plusMinutes(minute).toInstant(ZoneOffset.of("-03:00")));
    }
}
