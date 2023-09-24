package br.com.somar.app.users.adapters.inbound.controllers.requests;

import br.com.somar.app.users.application.core.domain.User;

public record UserFilterRequest(String email) {
    public User toUserDomain() {
        return User.builder().email(email);
    }
}
