package br.com.somar.app.adapters.inbound.controllers.responses.profiles;

import br.com.somar.app.adapters.inbound.controllers.responses.UserResponse;
import br.com.somar.app.adapters.inbound.controllers.responses.abilities.AbilityResponse;
import br.com.somar.app.application.domain.Ability;
import br.com.somar.app.application.domain.Auth;
import br.com.somar.app.application.domain.Profile;
import br.com.somar.app.application.domain.User;

import java.util.Set;

public class ProfileResponse {
    private String name;
    private Set<Ability> abilities;

    public ProfileResponse(String name, Set<Ability> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public static ProfileResponse fromDomain(Profile profile) {
        return new ProfileResponse(profile.getName(), profile.getAbilities());
    }
}
