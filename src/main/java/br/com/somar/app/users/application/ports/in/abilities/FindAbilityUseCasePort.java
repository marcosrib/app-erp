package br.com.somar.app.users.application.ports.in.abilities;

import br.com.somar.app.users.application.core.domain.AbilityGroup;

import java.util.List;

public interface FindAbilityUseCasePort {
    List<AbilityGroup> findAbilityByProfileId(Long profileId);
    List<AbilityGroup> findAllAbilities();
}