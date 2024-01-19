package br.com.erp.app.users.adapters.inbound.controllers.responses.users;

import br.com.erp.app.users.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.erp.app.users.application.core.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private boolean status;
    private Set<ProfileResponse> profiles;

    public static UserResponse fromDomain(User user) {
        Set<ProfileResponse> profiles = user.getProfiles().stream().map(profile ->
                        new ProfileResponse(profile.getId(), profile.getName(), profile.getDescription()))
                .collect(Collectors.toSet());

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .status(user.isStatus())
                .email(user.getEmail())
                .profiles(profiles)
                .build();
    }

    public static List<UserResponse> fromDomainToList(List<User> users) {
        return users.stream().map(UserResponse::fromDomain).collect(Collectors.toList());
    }

}
