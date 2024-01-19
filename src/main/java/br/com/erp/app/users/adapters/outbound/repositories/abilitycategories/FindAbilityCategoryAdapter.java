package br.com.erp.app.users.adapters.outbound.repositories.abilitycategories;

import br.com.erp.app.users.application.core.domain.AbilityCategory;
import br.com.erp.app.users.application.ports.out.abilitycategories.FindAbilityCategoryAdapterPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FindAbilityCategoryAdapter implements FindAbilityCategoryAdapterPort {
    private final AbilityCategoryRepository abilityCategoryRepository;

    public FindAbilityCategoryAdapter(AbilityCategoryRepository abilityCategoryRepository) {
        this.abilityCategoryRepository = abilityCategoryRepository;
    }

    @Override
    public Set<AbilityCategory> findCodeByIn(List<String> codes) {
        return AbilityCategory.convertListAbilityCategoryEntityIntoListAbilityCategory(abilityCategoryRepository.findByCodeIn(codes));
    }
}
