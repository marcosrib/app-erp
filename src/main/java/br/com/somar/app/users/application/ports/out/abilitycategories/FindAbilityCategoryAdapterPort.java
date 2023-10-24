package br.com.somar.app.users.application.ports.out.abilitycategories;

import br.com.somar.app.users.application.core.domain.AbilityCategory;

import java.util.List;
import java.util.Set;

public interface FindAbilityCategoryAdapterPort {
    Set<AbilityCategory> findCodeByIn(List<String> codes);
}
