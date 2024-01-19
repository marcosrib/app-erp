package br.com.erp.app.users.adapters.inbound.controllers.responses.authentication;

import br.com.erp.app.users.adapters.inbound.controllers.responses.abilities.AuthorityResponse;
import br.com.erp.app.users.application.core.domain.Auth;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;
    private Set<AuthorityResponse> authorities;

    public static AuthenticationResponse fromDomain(Auth auth) {
        var authorities = auth.getAuthorities().stream()
                .map(AuthorityResponse::new)
                .collect(Collectors.toSet());
        return AuthenticationResponse
                .builder()
                .accessToken(auth.getAccessToken())
                .refreshToken(auth.getRefreshToken())
                .authorities(authorities)
                .build();
    }
}
