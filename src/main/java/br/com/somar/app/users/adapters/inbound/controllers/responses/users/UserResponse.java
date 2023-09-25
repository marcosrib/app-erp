package br.com.somar.app.users.adapters.inbound.controllers.responses.users;

import br.com.somar.app.users.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.core.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Set<ProfileResponse> profiles;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email,
                        Set<ProfileResponse> profiles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profiles = profiles;
    }

    public static UserResponse fromDomain(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(),
                user.getProfiles().stream().map(profile -> ProfileResponse.builder()
                        .id(profile.getId())
                        .name(profile.getName())
                        .build()).collect(Collectors.toSet()));
    }

}
