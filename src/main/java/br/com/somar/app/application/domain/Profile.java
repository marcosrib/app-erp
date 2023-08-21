package br.com.somar.app.application.domain;

import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class Profile {

    private Long id;
    private String name;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Profile convertProfileEntityToProfile(ProfileEntity profilesEntity) {
        var abilities =  profilesEntity.getAbilities().stream()
                .map(ability -> new Ability(ability.getId(),
                        ability.getAbilityCategory().getName(),
                        ability.getAbilityGroup().getName(),
                        true))
                .collect(Collectors.toSet());
        return new Profile(profilesEntity.getId(), profilesEntity.getName(), abilities);
    }
}
