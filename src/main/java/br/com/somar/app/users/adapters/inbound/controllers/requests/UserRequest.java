package br.com.somar.app.users.adapters.inbound.controllers.requests;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.core.domain.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Set<Profile> profiles;

    public User toUserDomain() {

        Set<Profile> profilesList = new HashSet<>();
        profilesList.addAll(profiles);
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .profiles(profilesList);
    }
}
