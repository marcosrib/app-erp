package br.com.somar.app.users.adapters.inbound.controllers.responses.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProfileResponse {
    private Long id;
    private String name;

    public ProfileResponse() {
    }
    public ProfileResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<ProfileResponse> fromDomainToList(List<Profile> profiles) {
        return profiles.stream().map(profile -> new ProfileResponse(profile.getId(), profile.getName())).collect(Collectors.toList());
    }

}
