package br.com.somar.app.adapters.inbound.controllers.responses.abilities;

import br.com.somar.app.application.domain.Ability;
import br.com.somar.app.application.domain.GroupAbility;

import java.util.List;
import java.util.stream.Collectors;

public class GroupAbilityResponse {
    private String name;
    private List<AbilityResponse> abilities;

    public GroupAbilityResponse(String name, List<AbilityResponse> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public List<AbilityResponse> getAbilities() {
        return abilities;
    }

    public static List<GroupAbilityResponse> fromDomain(List<GroupAbility> abilities) {
        return abilities.stream()
                .map(group -> new GroupAbilityResponse(
                        group.getName(),
                        group.getAbilities().stream()
                                .map(ability -> new AbilityResponse(ability.getId(), ability.getName(), ability.isHasAbilityProfile()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
