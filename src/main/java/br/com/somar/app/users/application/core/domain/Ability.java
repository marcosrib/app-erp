package br.com.somar.app.users.application.core.domain;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityEntity;
import br.com.somar.app.users.application.core.domain.builders.AbilityBuilder;

import java.util.Set;
import java.util.stream.Collectors;

public class Ability {
    private Long id;
    private String name;
    private String groupName;
    private Long groupAbilityId;
    private Long categoryAbilityId;

    private boolean hasAbilityProfile;

    public Ability() {
    }



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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isHasAbilityProfile() {
        return hasAbilityProfile;
    }

    public Long getGroupAbilityId() {
        return groupAbilityId;
    }

    public void setGroupAbilityId(Long groupAbilityId) {
        this.groupAbilityId = groupAbilityId;
    }

    public Long getCategoryAbilityId() {
        return categoryAbilityId;
    }

    public void setCategoryAbilityId(Long categoryAbilityId) {
        this.categoryAbilityId = categoryAbilityId;
    }

    public void setHasAbilityProfile(boolean hasAbilityProfile) {
        this.hasAbilityProfile = hasAbilityProfile;
    }

    public static AbilityBuilder builder() {
        return new AbilityBuilder();
    }

    public static Set<Ability> convertListAbilityEntityToListAbility(Set<AbilityEntity> abilities) {
        return abilities.stream()
                .map(abilityEntity -> Ability
                        .builder()
                        .id(abilityEntity.getId())
                        .name(abilityEntity.getAbilityCategory().getName())
                        .groupName(abilityEntity.getAbilityGroup().getName())
                        .hasAbilityProfile(false)
                        .build())
                .collect(Collectors.toSet());
    }

}