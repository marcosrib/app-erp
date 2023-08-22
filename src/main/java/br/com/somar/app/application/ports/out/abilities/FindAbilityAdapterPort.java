package br.com.somar.app.application.ports.out.abilities;

import br.com.somar.app.application.domain.Ability;

import java.util.List;
import java.util.Set;

public interface FindAbilityAdapterPort {
    Set<Ability> findAbilityNotInIds(List<Long> ids);

    Set<Ability> findAllAbilities();
}
