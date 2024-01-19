package br.com.erp.app.users.adapters.outbound.repositories.users;

import br.com.erp.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.erp.app.users.adapters.outbound.repositories.profiles.ProfileEntityMapper;
import br.com.erp.app.users.application.core.domain.User;

public class UserEntityMapper {

    public static UserEntity convertUserToEntity(User user) {

        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .status(user.isStatus())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .profiles(ProfileEntityMapper.convertListProfileToListEntity(user.getProfiles()))
                .build();
    }
}
