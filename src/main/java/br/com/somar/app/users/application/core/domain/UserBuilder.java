package br.com.somar.app.users.application.core.domain;

import java.time.LocalDateTime;
import java.util.Set;

public class UserBuilder {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean status;
    private LocalDateTime createdAt;
    private Set<Profile> profiles;

    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder profiles(Set<Profile> profiles) {
        this.profiles = profiles;
        return this;
    }

    public UserBuilder status(boolean status) {
        this.status = status;
        return this;
    }

    public UserBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(status);
        user.setCreatedAt(createdAt);
        user.setProfiles(profiles);
        return user;
    }
}
