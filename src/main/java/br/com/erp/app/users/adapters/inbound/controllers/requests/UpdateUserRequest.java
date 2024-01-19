package br.com.erp.app.users.adapters.inbound.controllers.requests;

import br.com.erp.app.users.application.core.domain.Profile;
import br.com.erp.app.users.application.core.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UpdateUserRequest {

    @NotNull(message = "{name.not.empty}")
    private String name;

    @Email(message = "{email.invalid}")
    private String email;

    private String password;

    private boolean status;

    @NotNull(message = "{profile.not.empty}")
    @NotEmpty(message = "{profile.not.empty}")
    private Set<ProfileRequest> profiles;

    public User toUserDomain() {

        Set<Profile> profiles = getProfiles()
                .stream()
                .map(profileRequest -> Profile
                        .builder()
                        .id(profileRequest.id())
                        .build())
                .collect(Collectors.toSet());
        User user = User.builder()
                .name(name)
                .email(email)
                .status(status)
                .password(password)
                .profiles(profiles)
                .build();
        return user;
    }
}
