package br.com.somar.app.application.domain;

import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class Profile {

    private Long id;
    private String name;

    public Profile() {
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

    public void setName(String name) {
        this.name = name;
    }
    public static Set<Profile> convertProfileEntityToProfile(Set<ProfileEntity> profilesEntity) {
        return profilesEntity.stream()
                .map(profile -> new Profile(profile.getId(), profile.getName()))
                .collect(Collectors.toSet());
    }
}
