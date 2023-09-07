package br.com.somar.app.users.application.ports.in.abilities;

import br.com.somar.app.users.application.core.domain.GroupAbility;

import java.util.List;

public interface FindAbilityUseCasePort {
    List<GroupAbility> findAbilityByProfileId(Long profileId);
}