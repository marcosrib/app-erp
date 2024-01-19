package br.com.erp.app.unit.users.application.core.usecases.abilities;

import br.com.erp.app.unit.users.builders.domain.AbilityCategoryFakeBuilder;
import br.com.erp.app.unit.users.builders.domain.AbilityFakeBuilder;
import br.com.erp.app.unit.users.builders.domain.AbilityGroupFakeBuilder;
import br.com.erp.app.unit.users.builders.fileproperties.AbilityFilePropertiesFakeBuilder;
import br.com.erp.app.unit.users.builders.fileproperties.GroupFilePropertiesFakeBuilder;
import br.com.erp.app.users.adapters.outbound.fileproperties.GetAbilitiesIntoPropertiesFile;
import br.com.erp.app.users.application.core.usecases.abilities.CreateAbilityUseCase;
import br.com.erp.app.users.application.ports.in.abilitycategories.CreateAbilityCategoryUseCasePort;
import br.com.erp.app.users.application.ports.in.abilitygroups.CreateAbilityGroupUseCasePort;
import br.com.erp.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;
import br.com.erp.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateAbilityUseCaseTest {
    @Mock
    private CreateAbilityAdapterPort createAbilityAdapterPort;
    @Mock
    private GetAbilitiesIntoPropertiesFile getAbilitiesIntoPropertiesFile;
    @Mock
    private FindAbilityAdapterPort findAbilityAdapterPort;
    @Mock
    private CreateAbilityGroupUseCasePort createAbilityGroupUseCasePort;
    @Mock
    private CreateAbilityCategoryUseCasePort createAbilityCategoryUseCasePort;
    @InjectMocks
    private CreateAbilityUseCase createAbilityUseCase;

    @DisplayName("should successfully create ability is ability not existing")
    @Test
    void createAbilityInNotExisting() {
        var groupFileProperties = new GroupFilePropertiesFakeBuilder().getFake(1);
        var abilityCategory = new AbilityCategoryFakeBuilder().getFake(1);
        var abilityGroup = new AbilityGroupFakeBuilder().getFake();
        when(getAbilitiesIntoPropertiesFile.getAbilityGroups())
                .thenReturn(groupFileProperties);
        when(findAbilityAdapterPort.findAbilityByGroupId(anyLong()))
                .thenReturn(Collections.emptySet());
        when(createAbilityCategoryUseCasePort.findOrCreate(any()))
                .thenReturn(abilityCategory);
        when(createAbilityGroupUseCasePort.findOrCreate(any()))
                .thenReturn(abilityGroup);

        createAbilityUseCase.create();

        verify(createAbilityCategoryUseCasePort, times(1)).findOrCreate(any());
        verify(createAbilityGroupUseCasePort, times(1)).findOrCreate(any());
        verify(createAbilityAdapterPort, atLeastOnce()).create(anySet());

    }

    @DisplayName("should create successfully if the ability exists and is different from the one being registered")
    @Test
    void createExistingAndDifferentAbility() {
        var groupFileProperties = new GroupFilePropertiesFakeBuilder().getFake(1);
        var abilityCategory = new AbilityCategoryFakeBuilder().getFake(1);
        var abilities = new AbilityFakeBuilder().getFake(1);
        var abilityGroup = new AbilityGroupFakeBuilder().getFake();
        when(getAbilitiesIntoPropertiesFile.getAbilityGroups())
                .thenReturn(groupFileProperties);
        when(findAbilityAdapterPort.findAbilityByGroupId(anyLong()))
                .thenReturn(abilities);
        when(createAbilityCategoryUseCasePort.findOrCreate(any()))
                .thenReturn(abilityCategory);
        when(createAbilityGroupUseCasePort.findOrCreate(any()))
                .thenReturn(abilityGroup);

        createAbilityUseCase.create();

        verify(createAbilityCategoryUseCasePort, times(1)).findOrCreate(any());
        verify(createAbilityGroupUseCasePort, times(1)).findOrCreate(any());
        verify(createAbilityAdapterPort, atLeastOnce()).create(anySet());
    }

    @DisplayName("should create successfully if the ability exists and is different from the one being registered")
    @Test
    void createExistingAndEqualAbility() {
        var abilityCategory = new AbilityCategoryFakeBuilder()
                .getFake();
        abilityCategory.setId(1L);

        var abilityFileProperties = new AbilityFilePropertiesFakeBuilder()
                .getFake();
        abilityCategory.setId(1L);

        var groupFileProperties = new GroupFilePropertiesFakeBuilder()
                .getFake();
        groupFileProperties.setAbilities(new ArrayList<>());
        groupFileProperties.getAbilities().add(abilityFileProperties);


        var ability = new AbilityFakeBuilder().getFake();
        ability.setAbilityCategory(abilityCategory);
        var abilityGroup = new AbilityGroupFakeBuilder().getFake();

        when(getAbilitiesIntoPropertiesFile.getAbilityGroups())
                .thenReturn(Collections.singletonList(groupFileProperties));
        when(findAbilityAdapterPort.findAbilityByGroupId(anyLong()))
                .thenReturn(Set.of(ability));
        when(createAbilityCategoryUseCasePort.findOrCreate(any()))
                .thenReturn(Set.of(abilityCategory));
        when(createAbilityGroupUseCasePort.findOrCreate(any()))
                .thenReturn(abilityGroup);

        createAbilityUseCase.create();

        verify(createAbilityAdapterPort, times(0)).create(any());
        verify(createAbilityGroupUseCasePort, times(1)).findOrCreate(any());
    }
}
