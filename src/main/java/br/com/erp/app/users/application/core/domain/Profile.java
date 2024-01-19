package br.com.erp.app.users.application.core.domain;

import br.com.erp.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.erp.app.users.application.core.domain.builders.ProfileBuilder;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Profile {

    private Long id;
    private String name;
    private String description;
    private Set<Ability> abilities;

    public Profile() {
    }

    public Profile(String name) {
        this.name = name;
    }

    public Profile(Long id, String name, Set<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.abilities = abilities;
    }

    public Profile(ProfileEntity profileEntity) {
        this.id = profileEntity.getId();
        this.name = profileEntity.getName();
    }

    public static ProfileBuilder builder() {
        return new ProfileBuilder();
    }

    public static Profile convertProfileEntityToProfile(ProfileEntity profilesEntity) {
        if (ObjectUtils.isEmpty(profilesEntity)) return null;
        return Profile.builder()
                .name(profilesEntity.getName())
                .id(profilesEntity.getId())
                .description(profilesEntity.getDescription())
                .build();
    }

    public static Profile convertProfileEntityToProfileWithAbilities(ProfileEntity profilesEntity) {
        var abilities = profilesEntity.getAbilities().stream()
                .map(ability -> Ability
                        .builder()
                        .id(ability.getId())
                        .abilityCategory(new AbilityCategory(
                                ability.getAbilityCategory().getId(),
                                ability.getAbilityCategory().getName(),
                                ability.getAbilityCategory().getCode()))
                        .abilityGroup(new AbilityGroup(
                                ability.getAbilityGroup().getId(),
                                ability.getAbilityGroup().getName(),
                                ability.getAbilityGroup().getCode()))
                        .hasAbilityProfile(true)
                        .build())
                .collect(Collectors.toSet());
        return new Profile(profilesEntity.getId(), profilesEntity.getName(), abilities);
    }

    public static Set<Profile> convertListProfileEntityIntoListProfile(List<ProfileEntity> profileEntities) {
        return profileEntities.stream().map(profile -> Profile
                .builder()
                .id(profile.getId())
                .name(profile.getName())
                .description(profile.getDescription())
                .build()).collect(Collectors.toSet());
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

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
