package br.com.erp.app.users.adapters.inbound.controllers.responses.abilities;

import br.com.erp.app.users.application.core.domain.AbilityGroup;

import java.util.List;
import java.util.stream.Collectors;

public class GroupAbilityResponse {
    private final String name;
    private final List<AbilityResponse> abilities;

    public GroupAbilityResponse(String name, List<AbilityResponse> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public static List<GroupAbilityResponse> fromDomain(List<AbilityGroup> abilities) {
        return abilities.stream()
                .map(group -> new GroupAbilityResponse(
                        group.getName(),
                        group.getAbilities().stream()
                                .map(ability -> new AbilityResponse(ability.getId(), ability.getName(), ability.isHasAbilityProfile()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<AbilityResponse> getAbilities() {
        return abilities;
    }
}
