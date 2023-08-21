package br.com.somar.app.application.ports.in.abilities;

import br.com.somar.app.application.domain.GroupAbility;

import java.util.List;

public interface FindAbilityUseCasePort {
    List<GroupAbility> findAbilityByProfileId(Long profileId);
}