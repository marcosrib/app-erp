package br.com.somar.app.users.application.core.usecases.abilitygroups;

import br.com.somar.app.users.adapters.outbound.fileproperties.GroupFileProperties;
import br.com.somar.app.users.application.core.domain.AbilityGroup;
import br.com.somar.app.users.application.ports.in.abilitygroups.CreateAbilityGroupUseCasePort;
import br.com.somar.app.users.application.ports.out.abilitygroups.CreateAbilityGroupAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitygroups.FindAbilityGroupAdapterPort;
import org.apache.commons.lang3.ObjectUtils;

public class CreateAbilityGroupUseCase implements CreateAbilityGroupUseCasePort {
    private final FindAbilityGroupAdapterPort findAbilityGroupAdapterPort;
    private final CreateAbilityGroupAdapterPort createAbilityGroupAdapterPort;

    public CreateAbilityGroupUseCase(FindAbilityGroupAdapterPort findAbilityGroupAdapterPort, CreateAbilityGroupAdapterPort createAbilityGroupAdapterPort) {
        this.findAbilityGroupAdapterPort = findAbilityGroupAdapterPort;
        this.createAbilityGroupAdapterPort = createAbilityGroupAdapterPort;
    }

    @Override
    public AbilityGroup findOrCreate(GroupFileProperties groupFileProperties) {
        AbilityGroup abilityGroup = findAbilityGroupAdapterPort.findAbilityGroupByCode(groupFileProperties.getCode());
        if (ObjectUtils.isNotEmpty(abilityGroup)) {
            return abilityGroup;
        }
        return createAbilityGroupAdapterPort.create(new AbilityGroup(groupFileProperties.getName(), groupFileProperties.getCode()));
    }

}
