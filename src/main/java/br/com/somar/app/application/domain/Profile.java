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
    public Profile(Long id, String name) {
        this.id = id;
        this.name = name;
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
        return new Profile(profilesEntity.getId(), profilesEntity.getName());
    }
}
