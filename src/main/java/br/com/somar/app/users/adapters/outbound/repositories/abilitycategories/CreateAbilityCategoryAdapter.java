package br.com.somar.app.users.adapters.outbound.repositories.abilitycategories;

import br.com.somar.app.users.application.core.domain.AbilityCategory;
import br.com.somar.app.users.application.ports.out.abilitycategories.CreateAbilityCategoryAdapterPort;
import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CreateAbilityCategoryAdapter implements CreateAbilityCategoryAdapterPort {

    private final AbilityCategoryRepository abilityCategoryRepository;

    public CreateAbilityCategoryAdapter(AbilityCategoryRepository abilityCategoryRepository) {
        this.abilityCategoryRepository = abilityCategoryRepository;
    }

    @Override
    public Set<AbilityCategory> createAll(Set<AbilityCategory> abilityCategories) {
       var abilityCategoryEntities =  abilityCategoryRepository.saveAll(convertListAbilityCategoryIntoListAbilityCategoryEntity(abilityCategories));
       return AbilityCategory.convertListAbilityCategoryEntityIntoListAbilityCategory(abilityCategoryEntities);

    }

    public Set<AbilityCategoryEntity> convertListAbilityCategoryIntoListAbilityCategoryEntity(Set<AbilityCategory> abilityCategories) {
        return abilityCategories.stream().map(abilityCategory ->
                        AbilityCategoryEntity
                                .builder()
                                .code(abilityCategory.getCode())
                                .name(abilityCategory.getName())
                                .build())
                .collect(Collectors.toSet());
    }
}
