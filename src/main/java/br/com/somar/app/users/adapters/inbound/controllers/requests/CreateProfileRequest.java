package br.com.somar.app.users.adapters.inbound.controllers.requests;

import br.com.somar.app.users.application.core.domain.Profile;

public record CreateProfileRequest(String name) {
    public Profile toProfileDomain() {
        return new Profile(name);
    }
}
