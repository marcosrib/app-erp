package br.com.erp.app.users.application.core.domain;

import br.com.erp.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.erp.app.users.adapters.outbound.repositories.entity.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class Auth {
    private String email;

    private String name;

    private String password;
    private String accessToken;
    private String refreshToken;

    private Set<Authority> authorities;

    public Auth() {
    }

    public static Auth builder() {
        return new Auth();
    }

    public static Auth convertUserEntityToAuth(UserEntity userEntity, String accessToken, String refreshToken) {
        var authorities = convertAbilityToAuthorities(userEntity.getProfiles());
        return Auth.builder()
                .name(userEntity.getName())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authorities(authorities);
    }

    public static Auth convertUserEntityToAuth(UserEntity userEntity) {
        var authorities = convertAbilityToAuthorities(userEntity.getProfiles());
        return Auth.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(authorities);
    }

    public static Auth convertUserEntityToAuth(User user) {
        return Auth.builder()
                .email(user.getEmail())
                .name(user.getName());
    }

    private static Set<Authority> convertAbilityToAuthorities(Set<ProfileEntity> profiles) {
        return profiles.stream()
                .flatMap(profile -> profile.getAbilities().stream())
                .map(ability -> new Authority(ability.getAbilityGroup().getCode(), ability.getAbilityCategory().getCode()))
                .collect(Collectors.toSet());
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Auth email(String email) {
        this.email = email;
        return this;
    }

    public Auth name(String name) {
        this.name = name;
        return this;
    }

    public Auth password(String password) {
        this.password = password;
        return this;
    }

    public Auth accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Auth refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public Auth authorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }
}
