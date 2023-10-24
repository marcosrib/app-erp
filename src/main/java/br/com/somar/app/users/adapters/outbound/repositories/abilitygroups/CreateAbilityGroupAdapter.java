package br.com.somar.app.users.adapters.outbound.repositories.abilitygroups;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityGroupEntity;
import br.com.somar.app.users.application.core.domain.AbilityGroup;
import br.com.somar.app.users.application.ports.out.abilitygroups.CreateAbilityGroupAdapterPort;
import org.springframework.stereotype.Service;
@Service
public class CreateAbilityGroupAdapter implements CreateAbilityGroupAdapterPort {
    private final AbilityGroupRepository abilityGroupRepository;

    public CreateAbilityGroupAdapter(AbilityGroupRepository abilityGroupRepository) {
        this.abilityGroupRepository = abilityGroupRepository;
    }

    @Override
    public AbilityGroup create(AbilityGroup abilityGroup) {

       AbilityGroupEntity abilityGroupEntity = abilityGroupRepository.save(AbilityGroupEntity
                .builder()
                .id(abilityGroup.getId())
                .code(abilityGroup.getCode())
                .name(abilityGroup.getName())
                .build());
        return AbilityGroup.convertAbilityGroupEntityIntoAbilityGroup(abilityGroupEntity);
    }
}
