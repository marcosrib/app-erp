package br.com.somar.app.users.application.ports.out.abilitygroups;

import br.com.somar.app.users.application.core.domain.AbilityGroup;

public  interface FindAbilityGroupAdapterPort {
    AbilityGroup findAbilityGroupByCode(String code);
}
