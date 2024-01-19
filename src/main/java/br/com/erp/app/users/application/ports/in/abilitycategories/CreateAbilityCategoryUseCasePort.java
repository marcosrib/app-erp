package br.com.erp.app.users.application.ports.in.abilitycategories;

import br.com.erp.app.users.adapters.outbound.fileproperties.AbilityFileProperties;
import br.com.erp.app.users.application.core.domain.AbilityCategory;

import java.util.List;
import java.util.Set;

public interface CreateAbilityCategoryUseCasePort {
    Set<AbilityCategory> findOrCreate(List<AbilityFileProperties> abilityFileProperties);
}
