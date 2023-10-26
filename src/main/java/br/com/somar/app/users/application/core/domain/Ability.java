package br.com.somar.app.users.application.core.domain;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityCategoryEntity;
import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityEntity;
import br.com.somar.app.users.application.core.domain.builders.AbilityBuilder;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Ability {
    private Long id;
    private String name;
    private AbilityGroup abilityGroup;
    private AbilityCategory abilityCategory;
    private boolean hasAbilityProfile;

    public Ability() {
    }

    public Ability(Long id, String name, boolean hasAbilityProfile) {
        this.id = id;
        this.name = name;
        this.hasAbilityProfile = hasAbilityProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasAbilityProfile() {
        return hasAbilityProfile;
    }

    public AbilityGroup getAbilityGroup() {
        return abilityGroup;
    }

    public void setAbilityGroup(AbilityGroup abilityGroup) {
        this.abilityGroup = abilityGroup;
    }

    public AbilityCategory getAbilityCategory() {
        return abilityCategory;
    }

    public void setAbilityCategory(AbilityCategory abilityCategory) {
        this.abilityCategory = abilityCategory;
    }


    public static AbilityBuilder builder() {
        return new AbilityBuilder();
    }

    public static Set<Ability> convertListAbilityEntityToListAbility(Set<AbilityEntity> abilities) {
        if(abilities.isEmpty()) Collections.emptySet();
        return abilities.stream()
                .map(abilityEntity -> Ability
                        .builder()
                        .id(abilityEntity.getId())
                        .name(abilityEntity.getAbilityCategory().getName())
                        .groupName(abilityEntity.getAbilityGroup().getName())
                        .abilityCategory(new AbilityCategory(
                                abilityEntity.getAbilityCategory().getId(),
                                abilityEntity.getAbilityCategory().getName(),
                                abilityEntity.getAbilityCategory().getCode())
                        )
                        .abilityGroup(new AbilityGroup(
                                abilityEntity.getAbilityGroup().getId(),
                                abilityEntity.getAbilityGroup().getName(),
                                abilityEntity.getAbilityGroup().getCode())
                                )
                        .hasAbilityProfile(false)
                        .build())
                .collect(Collectors.toSet());
    }

}