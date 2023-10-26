package br.com.somar.app.users.application.ports.in.abilitygroups;

import br.com.somar.app.users.adapters.outbound.fileproperties.GroupFileProperties;
import br.com.somar.app.users.application.core.domain.AbilityGroup;

public interface CreateAbilityGroupUseCasePort {
    AbilityGroup findOrCreate(GroupFileProperties groupFileProperties);
}
