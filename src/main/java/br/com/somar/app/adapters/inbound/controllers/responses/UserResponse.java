package br.com.somar.app.adapters.inbound.controllers.responses;

import br.com.somar.app.application.domain.Profile;
import br.com.somar.app.application.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Set<Profile> profiles;

    public UserResponse() {

    }

    public UserResponse(Long id, String name, String email,
                        Set<Profile> profiles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profiles = profiles;
    }

    public static UserResponse fromDomain(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(),
                user.getProfiles());
    }
}
