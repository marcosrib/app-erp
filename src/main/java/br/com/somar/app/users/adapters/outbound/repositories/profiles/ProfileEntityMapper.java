package br.com.somar.app.users.adapters.outbound.repositories.profiles;

import br.com.somar.app.users.adapters.outbound.repositories.abilities.AbilityEntityMapper;
import br.com.somar.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.users.application.core.domain.Profile;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfileEntityMapper {
    public static Set<ProfileEntity> convertListProfileToListEntity(Set<Profile> profiles) {
        return profiles.stream()
                .map(p -> ProfileEntity.
                        builder()
                        .id(p.getId())
                        .name(p.getName())
                        .build()
                ).collect(Collectors.toSet());
    }
    public static ProfileEntity convertProfileToEntityWithAbilities(Profile profile) {
        return ProfileEntity.
                        builder()
                        .id(profile.getId())
                        .name(profile.getName())
                        .abilities(AbilityEntityMapper.convertAbilitiesIntoAbilitiesEntity(profile.getAbilities()))
                        .build();
    }
}
