package br.com.erp.app.users.adapters.outbound.repositories.abilitygroups;

import br.com.erp.app.users.adapters.outbound.repositories.entity.AbilityGroupEntity;
import br.com.erp.app.users.application.core.domain.AbilityGroup;
import br.com.erp.app.users.application.ports.out.abilitygroups.FindAbilityGroupAdapterPort;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class FindAbilityGroupAdapter implements FindAbilityGroupAdapterPort {

    private final AbilityGroupRepository abilityGroupRepository;

    public FindAbilityGroupAdapter(AbilityGroupRepository abilityGroupRepository) {
        this.abilityGroupRepository = abilityGroupRepository;
    }

    @Override
    public AbilityGroup findAbilityGroupByCode(String code) {
        AbilityGroupEntity abilityGroupEntity = abilityGroupRepository.findByCode(code);
        if (ObjectUtils.isEmpty(abilityGroupEntity)) {
            return null;
        }
        return AbilityGroup.convertAbilityGroupEntityIntoAbilityGroup(abilityGroupEntity);
    }
}
