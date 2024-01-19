package br.com.erp.app.users.application.core.usecases.abilities;

import br.com.erp.app.users.adapters.outbound.fileproperties.GetAbilitiesIntoPropertiesFile;
import br.com.erp.app.users.adapters.outbound.fileproperties.GroupFileProperties;
import br.com.erp.app.users.application.core.domain.Ability;
import br.com.erp.app.users.application.core.domain.AbilityCategory;
import br.com.erp.app.users.application.core.domain.AbilityGroup;
import br.com.erp.app.users.application.ports.in.abilities.CreateAbilityUseCasePort;
import br.com.erp.app.users.application.ports.in.abilitycategories.CreateAbilityCategoryUseCasePort;
import br.com.erp.app.users.application.ports.in.abilitygroups.CreateAbilityGroupUseCasePort;
import br.com.erp.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;
import br.com.erp.app.users.application.ports.out.abilities.FindAbilityAdapterPort;

import java.util.Set;
import java.util.stream.Collectors;

public class CreateAbilityUseCase implements CreateAbilityUseCasePort {
    private final CreateAbilityAdapterPort createAbilityAdapterPort;
    private final GetAbilitiesIntoPropertiesFile getAbilitiesIntoPropertiesFile;
    private final FindAbilityAdapterPort findAbilityAdapterPort;
    private final CreateAbilityGroupUseCasePort createAbilityGroupUseCasePort;
    private final CreateAbilityCategoryUseCasePort createAbilityCategoryUseCasePort;

    public CreateAbilityUseCase(CreateAbilityAdapterPort createAbilityAdapterPort,
                                GetAbilitiesIntoPropertiesFile getAbilitiesIntoPropertiesFile,
                                FindAbilityAdapterPort findAbilityAdapterPort,
                                CreateAbilityGroupUseCasePort createAbilityGroupUseCasePort, CreateAbilityCategoryUseCasePort createAbilityCategoryUseCasePort) {
        this.createAbilityAdapterPort = createAbilityAdapterPort;
        this.getAbilitiesIntoPropertiesFile = getAbilitiesIntoPropertiesFile;
        this.findAbilityAdapterPort = findAbilityAdapterPort;
        this.createAbilityGroupUseCasePort = createAbilityGroupUseCasePort;
        this.createAbilityCategoryUseCasePort = createAbilityCategoryUseCasePort;
    }

    @Override
    public void create() {
        var groupsAbility = getAbilitiesIntoPropertiesFile.getAbilityGroups();
        for (GroupFileProperties groupFileProperties : groupsAbility) {
            var abilityGroup = createAbilityGroupUseCasePort.findOrCreate(groupFileProperties);
            var abilityCategories = createAbilityCategoryUseCasePort.findOrCreate(groupFileProperties.getAbilities());
            createAbilities(abilityGroup.getId(), abilityCategories);
        }
    }

    private void createAbilities(Long abilityGroupId, Set<AbilityCategory> abilityCategories) {
        var abilities = findAbilityAdapterPort.findAbilityByGroupId(abilityGroupId);
        if (abilities.isEmpty()) {
            createAbilityAdapterPort.create(addAbilityCategoryAndAbilityGroupIntoAbility(abilityGroupId, abilityCategories));
        }
        if (!abilities.isEmpty()) {
            var abilityCategoriesCompared = compareListAbilityWithAbilityCategories(abilities, abilityCategories);
            if (!abilityCategoriesCompared.isEmpty()) {
                createAbilityAdapterPort.create(addAbilityCategoryAndAbilityGroupIntoAbility(abilityGroupId, abilityCategoriesCompared));
            }
        }

    }

    private Set<Ability> addAbilityCategoryAndAbilityGroupIntoAbility(Long abilityGroupId, Set<AbilityCategory> abilityCategories) {
        return abilityCategories.stream().map(abilityCategory -> Ability
                .builder()
                .abilityGroup(new AbilityGroup(abilityGroupId))
                .abilityCategory(new AbilityCategory(abilityCategory.getId(),
                        abilityCategory.getName(),
                        abilityCategory.getCode())
                ).build()
        ).collect(Collectors.toSet());
    }

    private Set<AbilityCategory> compareListAbilityWithAbilityCategories(Set<Ability> abilities, Set<AbilityCategory> abilityCategories) {
        return abilityCategories.stream()
                .filter(abilityCategory ->
                        abilities
                                .stream()
                                .noneMatch(ability -> ability.getAbilityCategory().getId().equals(abilityCategory.getId())))
                .map(abilityCategory -> new AbilityCategory(abilityCategory.getId(), abilityCategory.getName(), abilityCategory.getCode()))
                .collect(Collectors.toSet());

    }

}
