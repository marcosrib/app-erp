package br.com.somar.app.adapters.outbound.repositories.abilities;

import br.com.somar.app.application.domain.Ability;
import br.com.somar.app.application.ports.out.abilities.FindAbilityAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FindAbilityAdapter implements FindAbilityAdapterPort {
    @Autowired
    private AbilityRepository abilityRepository;

    @Override
    public Set<Ability>  findAbilityNotInIds(List<Long> ids) {
        return Ability.convertListAbilityEntityToListAbility(abilityRepository.findByIdNotIn(ids));
    }
}
