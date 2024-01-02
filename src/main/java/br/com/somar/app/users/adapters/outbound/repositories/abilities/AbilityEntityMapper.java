package br.com.somar.app.users.adapters.outbound.repositories.abilities;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityCategoryEntity;
import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityEntity;
import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityGroupEntity;
import br.com.somar.app.users.application.core.domain.Ability;

import java.util.Set;
import java.util.stream.Collectors;

public class AbilityEntityMapper {

    public static Set<AbilityEntity> convertAbilitiesIntoAbilitiesEntity(Set<Ability> abilities) {
        return abilities.stream().map(ability -> AbilityEntity
                .builder()
                .id(ability.getId())
                .build()
        ).collect(Collectors.toSet());
    }

    public static Set<AbilityEntity> convertAbilitiesWithAbilityCategoryAndGroupIntoAbilitiesEntity(Set<Ability> abilities) {
        return abilities.stream().map(ability -> AbilityEntity
                .builder()
                .id(ability.getId())
                .abilityCategory(AbilityCategoryEntity.builder().id(ability.getAbilityCategory().getId()).build())
                .abilityGroup(AbilityGroupEntity.builder().id(ability.getAbilityGroup().getId()).build())
                .build()
        ).collect(Collectors.toSet());
    }
}
