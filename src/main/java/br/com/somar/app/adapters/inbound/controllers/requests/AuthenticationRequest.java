package br.com.somar.app.adapters.inbound.controllers.requests;

import br.com.somar.app.application.domain.Auth;

public record AuthenticationRequest(String email, String password) {
    public Auth toAuthDomain() {
        return new Auth(email, password);
    }
}
