package br.com.somar.app.adapters.inbound.controllers.responses.authentication;

import br.com.somar.app.application.domain.Auth;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;

    public static AuthenticationResponse fromDomain(Auth auth) {
        return AuthenticationResponse
            .builder()
            .accessToken(auth.getAccessToken())
            .refreshToken(auth.getRefreshToken())
            .build();
    }
}
