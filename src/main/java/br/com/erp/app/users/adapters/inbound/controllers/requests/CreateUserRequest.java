package br.com.erp.app.users.adapters.inbound.controllers.requests;

import br.com.erp.app.users.application.core.domain.Profile;
import br.com.erp.app.users.application.core.domain.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class CreateUserRequest {

    @NotEmpty(message = "{name.not.empty}")
    @NotNull(message = "{name.not.empty}")
    private String name;

    @Email(message = "{email.invalid}")
    private String email;

    @NotEmpty(message = "{password.not.empty}")
    @NotNull(message = "{password.not.empty}")
    private String password;

    private boolean status;

    @NotNull(message = "{profile.not.empty}")
    @NotEmpty(message = "{profile.not.empty}")
    @Valid
    private Set<ProfileRequest> profiles;

    public User toUserDomain() {

        Set<Profile> profiles = getProfiles()
                .stream()
                .map(profileRequest -> Profile
                        .builder()
                        .id(profileRequest.id())
                        .build())
                .collect(Collectors.toSet());
        return User.builder()
                .name(name)
                .email(email)
                .status(status)
                .password(password)
                .profiles(profiles)
                .build();
    }
}
