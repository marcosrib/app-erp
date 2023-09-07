package br.com.somar.app.users.adapters.inbound.controllers.requests;

import br.com.somar.app.users.application.core.domain.Auth;

public record AuthenticationRequest(String email, String password) {
    public Auth toAuthDomain() {
        return Auth
            .builder()
            .email(email)
            .password(password);
    }
}
