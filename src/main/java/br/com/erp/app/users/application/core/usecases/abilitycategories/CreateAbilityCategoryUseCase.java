package br.com.erp.app.users.application.core.usecases.abilitycategories;

import br.com.erp.app.users.adapters.outbound.fileproperties.AbilityFileProperties;
import br.com.erp.app.users.application.core.domain.AbilityCategory;
import br.com.erp.app.users.application.ports.in.abilitycategories.CreateAbilityCategoryUseCasePort;
import br.com.erp.app.users.application.ports.out.abilitycategories.CreateAbilityCategoryAdapterPort;
import br.com.erp.app.users.application.ports.out.abilitycategories.FindAbilityCategoryAdapterPort;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateAbilityCategoryUseCase implements CreateAbilityCategoryUseCasePort {

    private final FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort;
    private final CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort;

    public CreateAbilityCategoryUseCase(FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort, CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort) {
        this.findAbilityCategoryAdapterPort = findAbilityCategoryAdapterPort;
        this.createAbilityCategoryAdapterPort = createAbilityCategoryAdapterPort;
    }

    @Override
    public Set<AbilityCategory> findOrCreate(List<AbilityFileProperties> abilityFileProperties) {
        List<String> codeList = abilityFileProperties
                .stream()
                .map(abilityFile -> abilityFile.getCode()).toList();
        var abilityCategories = findAbilityCategoryAdapterPort.findCodeByIn(codeList);
        if (abilityCategories.isEmpty()) {
            return createAbilityCategoryAdapterPort.createAll(addAbilitiesIntoListAbilityCategories(abilityFileProperties));
        }
        var abilityCategoriesNotExisting = compareListAbilityFileWithAbilityCategories(abilityFileProperties, abilityCategories);
        if (!abilityCategoriesNotExisting.isEmpty()) {
            var abilityCategoriesNotExistingCreated = createAbilityCategoryAdapterPort.createAll(abilityCategoriesNotExisting);
            abilityCategories.addAll(abilityCategoriesNotExistingCreated);
        }
        return abilityCategories;
    }

    private Set<AbilityCategory> compareListAbilityFileWithAbilityCategories(List<AbilityFileProperties> abilityFileProperties, Set<AbilityCategory> abilityCategories) {
        return abilityFileProperties.stream()
                .filter(abilityFile ->
                        abilityCategories
                                .stream()
                                .noneMatch(abilityCategory -> abilityCategory.getCode().equals(abilityFile.getCode())))
                .map(abilityCategory -> new AbilityCategory(abilityCategory.getName(), abilityCategory.getCode()))
                .collect(Collectors.toSet());

    }

    private Set<AbilityCategory> addAbilitiesIntoListAbilityCategories(List<AbilityFileProperties> abilityFileProperties) {
        return abilityFileProperties.stream().map(abilityFile ->
                        new AbilityCategory(abilityFile.getName(), abilityFile.getCode()))
                .collect(Collectors.toSet());
    }
}
