package br.com.somar.app.application.domain;

import br.com.somar.app.adapters.outbound.repositories.entity.AbilityEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class Ability {
    private Long id;
    private String name;
    private String groupName;

    private boolean hasAbilityProfile;

    public Ability(Long id, String name, String groupName, boolean hasAbilityProfile) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
        this.hasAbilityProfile = hasAbilityProfile;
    }

    public Ability(Long id, String name, boolean hasAbilityProfile) {
        this.id = id;
        this.name = name;
        this.hasAbilityProfile = hasAbilityProfile;
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getName() {
        return name;
    }

    public boolean isHasAbilityProfile() {
        return hasAbilityProfile;
    }

    public static Set<Ability> convertListAbilityEntityToListAbility(Set<AbilityEntity> abilities) {
        return abilities.stream()
                .map(abilityEntity -> new Ability(abilityEntity.getId(),
                        abilityEntity.getAbilityCategory().getName(),
                        abilityEntity.getAbilityGroup().getName(),
                        false))
                .collect(Collectors.toSet());
    }
}
