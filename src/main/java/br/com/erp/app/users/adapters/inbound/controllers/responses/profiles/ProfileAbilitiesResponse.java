package br.com.erp.app.users.adapters.inbound.controllers.responses.profiles;

import br.com.erp.app.users.application.core.domain.Ability;
import br.com.erp.app.users.application.core.domain.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ProfileAbilitiesResponse {

    private Long id;
    private String name;
    private Set<Ability> abilities;

    public ProfileAbilitiesResponse() {
    }

    public ProfileAbilitiesResponse(String name, Set<Ability> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public static ProfileAbilitiesResponse fromDomain(Profile profile) {
        return new ProfileAbilitiesResponse(profile.getName(), profile.getAbilities());
    }


}
