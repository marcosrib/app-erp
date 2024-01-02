package br.com.somar.app.users.adapters.inbound.controllers.requests;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.core.domain.Profile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.stream.Collectors;

public record ProfileWithAbilitiesRequest(
        @NotBlank(message = "{name.not.empty}")
        @NotEmpty(message = "{name.not.empty}")
        String name,
        @Size(max=500, message="{description.max.characters}")
        String description,
        Set<AbilityRequest> abilities)
{

    public Profile toProfileDomain() {
        return Profile
                .builder()
                .name(name)
                .description(description)
                .abilities(abilities
                        .stream()
                        .map(abilityRequest ->
                                Ability.builder()
                                        .id(abilityRequest.id())
                                        .build()
                        ).collect(Collectors.toSet())
                )
                .build();
    }
}
