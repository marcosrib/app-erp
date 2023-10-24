package br.com.somar.app.users.application.core.domain;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.builders.UserBuilder;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean status;
    private LocalDateTime createdAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static User convertUserEntitytoUser(UserEntity userEntity) {
        Set<Profile> profiles = userEntity.getProfiles().stream()
                .map(profileEntity -> new Profile(profileEntity.getId(), profileEntity.getName()))
                .collect(Collectors.toSet());

        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .status(userEntity.getStatus())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .createdAt(userEntity.getCreatedAt())
                .profiles(profiles)
                .build();
    }

    public static List<User> convertPageUserEntityToListUser(Page<UserEntity> userEntityPage) {
        return userEntityPage.getContent().stream().map(userEntity -> User.convertUserEntitytoUser(userEntity))
                .collect(Collectors.toList());
    }

}
