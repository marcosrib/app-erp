package br.com.somar.app.adapters.inbound.controllers.requests;

import br.com.somar.app.application.domain.Auth;
import br.com.somar.app.application.domain.Profile;

public record CreateProfileRequest(String name) {
    public Profile toProfileDomain() {
        return new Profile(name);
    }
}
