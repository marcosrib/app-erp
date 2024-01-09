package br.com.somar.app.users.adapters.inbound.controllers.responses.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import lombok.Getter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ProfileResponse {
    private Long id;
    private String name;

    private String description;
    public ProfileResponse() {
    }
    public ProfileResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public static Set<ProfileResponse> fromDomainToList(Set<Profile> profiles) {
        return profiles.stream().map(profile -> new ProfileResponse(profile.getId(), profile.getName(), profile.getDescription())).collect(Collectors.toSet());
    }
    public  static  ProfileResponse fromDomain(Profile profile) {
        return new ProfileResponse(profile.getId(), profile.getName(), profile.getDescription());
    }

}
