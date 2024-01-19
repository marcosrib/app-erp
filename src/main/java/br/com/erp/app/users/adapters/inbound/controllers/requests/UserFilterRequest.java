package br.com.erp.app.users.adapters.inbound.controllers.requests;

import br.com.erp.app.users.application.core.domain.User;

public record UserFilterRequest(String email) {
    public User toUserDomain() {
        return User.builder().email(email).build();
    }
}
