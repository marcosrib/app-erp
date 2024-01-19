package br.com.erp.app.users.application.ports.out.abilitycategories;

import br.com.erp.app.users.application.core.domain.AbilityCategory;

import java.util.Set;

public interface CreateAbilityCategoryAdapterPort {
    Set<AbilityCategory> createAll(Set<AbilityCategory> abilityCategories);
}
