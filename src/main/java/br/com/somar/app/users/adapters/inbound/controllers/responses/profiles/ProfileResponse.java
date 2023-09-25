package br.com.somar.app.users.adapters.inbound.controllers.responses.profiles;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.core.domain.Profile;
import lombok.*;

import java.math.BigInteger;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ProfileResponse {

    private Long id;
    private String name;
    private Set<Ability> abilities;
    public ProfileResponse() {
    }
    public ProfileResponse(String name, Set<Ability> abilities) {
        this.name = name;
        this.abilities = abilities;
    }
    public static ProfileResponse fromDomain(Profile profile) {
        return new ProfileResponse(profile.getName(), profile.getAbilities());
    }


}
