package br.com.somar.app.users.application.core.domain;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean status;
    private Set<Profile> profiles;

    public User() {
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = email;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }
    public Set<Profile> getProfiles() {
        return profiles;
    }
    public static User builder() {
        return new User();
    }

    public User id(Long id) {
        this.id = id;
        return this;
    }
    public User email(String email) {
        this.email = email;
        return this;
    }
    public User password(String password) {
        this.password = password;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User profiles(Set<Profile> profiles) {
        this.profiles = profiles;
        return this;
    }
    public User status(Boolean status) {
        this.status = status;
        return this;
    }

    public static User convertUserEntitytoUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .status(userEntity.getStatus())
                .email(userEntity.getEmail());
    }

    public static Page<User> convertPageUserEntityToPAgeUser(Page<UserEntity> userEntityPage) {
        return userEntityPage.map(userEntity -> {
                    User user = User.convertUserEntitytoUser(userEntity);
                    Set<Profile> profiles = userEntity.getProfiles().stream()
                            .map(Profile::new)
                            .collect(Collectors.toSet());
                    user.setProfiles(profiles);
                    return user;
                });
    }

}
