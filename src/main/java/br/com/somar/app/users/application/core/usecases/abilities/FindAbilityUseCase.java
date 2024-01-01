package br.com.somar.app.users.application.core.usecases.abilities;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.core.domain.AbilityGroup;
import br.com.somar.app.users.application.ports.in.abilities.FindAbilityUseCasePort;

import java.util.*;
import java.util.stream.Collectors;

public class FindAbilityUseCase implements FindAbilityUseCasePort {

    private final FindProfileAdapterPort profileAdapterPort;
    private final FindAbilityAdapterPort findAbilityAdapterPort;

    public FindAbilityUseCase(FindProfileAdapterPort profileAdapterPort, FindAbilityAdapterPort findAbilityAdapterPort) {
        this.profileAdapterPort = profileAdapterPort;
        this.findAbilityAdapterPort = findAbilityAdapterPort;
    }

    @Override
    public List<AbilityGroup> findAbilityByProfileId(Long profileId) {
        var abilities = profileAdapterPort.findProfileBydIdWithAbilities(profileId).getAbilities();
        if (abilities.isEmpty()) abilities.addAll(findAbilityAdapterPort.findAllAbilities());
        else {
            var ids = abilities.stream().map(Ability::getId).collect(Collectors.toList());
            var abilitiesWithoutProfile = findAbilityAdapterPort.findAbilityNotInIds(ids);
            abilities.addAll(abilitiesWithoutProfile);
        }


        return covertAbility(abilities);
    }

    private List<AbilityGroup> covertAbility(Set<Ability> abilities) {
        var groups = new ArrayList<AbilityGroup>();
        var groupMap = new HashMap<String, AbilityGroup>();

        for (var ability : abilities) {
            AbilityGroup currentGroup;
            var groupName = ability.getAbilityGroup().getName();

            if (!groupMap.containsKey(groupName)) {
                currentGroup = new AbilityGroup(groupName, new ArrayList<>());
                groupMap.put(groupName, currentGroup);
                groups.add(currentGroup);
            } else {
                currentGroup = groupMap.get(groupName);
            }
            currentGroup.getAbilities().add(new Ability(ability.getId(), ability.getAbilityCategory().getName(), ability.isHasAbilityProfile()));
            currentGroup.getAbilities().sort(Comparator.comparing(Ability::getName));
        }

        groups.sort(Comparator.comparing(AbilityGroup::getName, String.CASE_INSENSITIVE_ORDER));

        return groups;
    }
}
