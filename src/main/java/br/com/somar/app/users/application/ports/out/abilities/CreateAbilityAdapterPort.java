package br.com.somar.app.users.application.ports.out.abilities;

import br.com.somar.app.users.application.core.domain.Ability;

import java.util.Set;

public interface CreateAbilityAdapterPort {
    void create(Set<Ability> ability);
}
