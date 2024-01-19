package br.com.erp.app.users.adapters.outbound.repositories.abilities;

import br.com.erp.app.users.application.core.domain.Ability;
import br.com.erp.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreateAbilityAdapter implements CreateAbilityAdapterPort {
    private final AbilityRepository abilityRepository;

    public CreateAbilityAdapter(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @Override
    public void create(Set<Ability> abilities) {

        var abilitiesConverted = AbilityEntityMapper.convertAbilitiesWithAbilityCategoryAndGroupIntoAbilitiesEntity(abilities);
        abilityRepository.saveAll(abilitiesConverted);
    }
}
