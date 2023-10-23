package br.com.somar.app.users.adapters.inbound.controllers.requests;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.core.domain.Profile;

import java.util.Set;
import java.util.stream.Collectors;

public record ProfileRequest(Long id, String name, Set<AbilityRequest> abilities) {

    public Profile toProfileDomain() {
        return Profile
                .builder()
                .id(id)
                .name(name)
                .abilities(abilities
                        .stream()
                        .map(abilityRequest ->
                                new Ability(abilityRequest.id())).collect(Collectors.toSet())
                )
                .build();
    }
}
