package br.com.somar.app.users.application.core.usecases.abilities;

import br.com.somar.app.users.adapters.outbound.fileproperties.AbilityFileProperties;
import br.com.somar.app.users.adapters.outbound.fileproperties.GetAbilitiesIntoYMLFile;
import br.com.somar.app.users.adapters.outbound.fileproperties.GroupFileProperties;
import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.core.domain.AbilityCategory;
import br.com.somar.app.users.application.core.domain.AbilityGroup;
import br.com.somar.app.users.application.ports.in.abilities.CreateAbilityUseCasePort;
import br.com.somar.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;
import br.com.somar.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitycategories.CreateAbilityCategoryAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitycategories.FindAbilityCategoryAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitygroups.CreateAbilityGroupAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitygroups.FindAbilityGroupAdapterPort;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateAbilityUseCase implements CreateAbilityUseCasePort {
    private final CreateAbilityAdapterPort createAbilityAdapterPort;
    private final GetAbilitiesIntoYMLFile getAbilitiesIntoYMLFile;
    private final FindAbilityGroupAdapterPort findAbilityGroupAdapterPort;
    private final CreateAbilityGroupAdapterPort createAbilityGroupAdapterPort;
    private final FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort;

    private final CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort;

    private final FindAbilityAdapterPort findAbilityAdapterPort;

    public CreateAbilityUseCase(CreateAbilityAdapterPort createAbilityAdapterPort,
                                GetAbilitiesIntoYMLFile getAbilitiesIntoYMLFile,
                                FindAbilityGroupAdapterPort findAbilityGroupAdapterPort,
                                CreateAbilityGroupAdapterPort createAbilityGroupAdapterPort,
                                FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort,
                                CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort, FindAbilityAdapterPort findAbilityAdapterPort) {
        this.createAbilityAdapterPort = createAbilityAdapterPort;
        this.getAbilitiesIntoYMLFile = getAbilitiesIntoYMLFile;
        this.findAbilityGroupAdapterPort = findAbilityGroupAdapterPort;
        this.createAbilityGroupAdapterPort = createAbilityGroupAdapterPort;
        this.findAbilityCategoryAdapterPort = findAbilityCategoryAdapterPort;
        this.createAbilityCategoryAdapterPort = createAbilityCategoryAdapterPort;
        this.findAbilityAdapterPort = findAbilityAdapterPort;
    }


    @Override
    public void create() {
        var groupsAbility = getAbilitiesIntoYMLFile.getAbilityGroups();
        for (GroupFileProperties groupFileProperties : groupsAbility) {
            var abilityGroup = createGroupAbility(groupFileProperties);
            var abilityCategories = createAbilityCategory(groupFileProperties.getAbilities());
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
            createAbilityAdapterPort.create(addAbilityCategoryAndAbilityGroupIntoAbility(abilityGroupId, abilityCategoriesCompared));
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
                .map(abilityCategory -> new AbilityCategory(abilityCategory.getId(),abilityCategory.getName(), abilityCategory.getCode()))
                .collect(Collectors.toSet());

    }

    private AbilityGroup createGroupAbility(GroupFileProperties groupFileProperties) {
        AbilityGroup abilityGroup = findAbilityGroupAdapterPort.findAbilityGroupByCode(groupFileProperties.getCode());
        if (ObjectUtils.isNotEmpty(abilityGroup)) {
            return abilityGroup;
        }
        return createAbilityGroupAdapterPort.create(new AbilityGroup(groupFileProperties.getName(), groupFileProperties.getCode()));
    }

    private Set<AbilityCategory> createAbilityCategory(List<AbilityFileProperties> abilityFileProperties) {
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
