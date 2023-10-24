package br.com.somar.app.users.adapters.outbound.repositories.abilities;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;
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

        var abilitiesConverted = AbilityEntityMapper.convertAbilitiesIntoAbilitiesEntity(abilities);
        abilityRepository.saveAll(abilitiesConverted);
    }
}
