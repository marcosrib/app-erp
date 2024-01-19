package br.com.erp.app.users.application.ports.in.abilitygroups;

import br.com.erp.app.users.adapters.outbound.fileproperties.GroupFileProperties;
import br.com.erp.app.users.application.core.domain.AbilityGroup;

public interface CreateAbilityGroupUseCasePort {
    AbilityGroup findOrCreate(GroupFileProperties groupFileProperties);
}
