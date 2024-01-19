package br.com.erp.app.users.application.ports.out.abilities;

import br.com.erp.app.users.application.core.domain.Ability;

import java.util.List;
import java.util.Set;

public interface FindAbilityAdapterPort {
    Set<Ability> findAbilityNotInIds(List<Long> ids);

    Set<Ability> findAbilityByGroupId(Long id);

    Set<Ability> findAllAbilities();
}
