package br.com.erp.app.users.adapters.inbound.controllers.responses.authentication;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RefreshTokenResponse {
    private String accessToken;
}
