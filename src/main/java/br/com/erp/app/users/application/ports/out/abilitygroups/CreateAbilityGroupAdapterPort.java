package br.com.erp.app.users.application.ports.out.abilitygroups;

import br.com.erp.app.users.application.core.domain.AbilityGroup;

public interface CreateAbilityGroupAdapterPort {
    AbilityGroup create(AbilityGroup abilityGroup);
}
