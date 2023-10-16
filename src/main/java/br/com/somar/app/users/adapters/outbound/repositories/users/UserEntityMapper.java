package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserEntityMapper {

    public static UserEntity convertUserToEntity(User user) {
        Set<ProfileEntity> profiles = user.getProfiles().stream()
                .map(p -> ProfileEntity.
                        builder()
                        .id(p.getId())
                        .name(p.getName())
                        .build()
                ).collect(Collectors.toSet());

        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .status(user.isStatus())
                .password(user.getPassword())
                .profiles(profiles)
                .build();
    }

    public static UserEntity convertUserToEntityUpdate(User user, UserEntity userEntity) {
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setStatus(user.isStatus());
        return userEntity;
    }
}
