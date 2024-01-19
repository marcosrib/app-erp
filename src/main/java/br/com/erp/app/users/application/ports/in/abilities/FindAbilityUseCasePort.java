package br.com.erp.app.users.application.ports.in.abilities;

import br.com.erp.app.users.application.core.domain.AbilityGroup;

import java.util.List;

public interface FindAbilityUseCasePort {
    List<AbilityGroup> findAbilityByProfileId(Long profileId);

    List<AbilityGroup> findAllAbilities();
}