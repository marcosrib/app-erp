package br.com.somar.app.users.application.core.usecases.abilities;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.core.domain.GroupAbility;
import br.com.somar.app.users.application.ports.in.abilities.FindAbilityUseCasePort;
import br.com.somar.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAbilityUseCase implements FindAbilityUseCasePort {

    private final FindProfileAdapterPort profileAdapterPort;
    private final FindAbilityAdapterPort findAbilityAdapterPort;

    public FindAbilityUseCase(FindProfileAdapterPort profileAdapterPort, FindAbilityAdapterPort findAbilityAdapterPort) {
        this.profileAdapterPort = profileAdapterPort;
        this.findAbilityAdapterPort = findAbilityAdapterPort;
    }

    @Override
    public List<GroupAbility> findAbilityByProfileId(Long profileId) {
        var abilities = profileAdapterPort.findProfileBydId(profileId).getAbilities();
        if (abilities.isEmpty()) {
            var allAbilities = findAbilityAdapterPort.findAllAbilities();
            abilities.addAll(allAbilities);
        } else {
            var ids = abilities.stream().map(Ability::getId).collect(Collectors.toList());
            var abilitiesWithoutProfile = findAbilityAdapterPort.findAbilityNotInIds(ids);
            abilities.addAll(abilitiesWithoutProfile);
        }


        return covertAbility(abilities);
    }

    private List<GroupAbility> covertAbility(Set<Ability> abilities) {
        var groups = new ArrayList<GroupAbility>();
        var groupMap = new HashMap<String, GroupAbility>();
        GroupAbility currentGroup = null;

        for (var ability : abilities) {
            var groupName = ability.getGroupName();

            if (!groupMap.containsKey(groupName)) {
                currentGroup = new GroupAbility(groupName, new ArrayList<>());
                groupMap.put(groupName, currentGroup);
                groups.add(currentGroup);
            } else {
                currentGroup = groupMap.get(groupName);
            }
            currentGroup.getAbilities().add(new Ability(ability.getId(), ability.getName(), ability.isHasAbilityProfile()));

        }
        return groups;
    }
}
