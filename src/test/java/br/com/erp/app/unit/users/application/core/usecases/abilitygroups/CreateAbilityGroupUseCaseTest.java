package br.com.erp.app.unit.users.application.core.usecases.abilitygroups;

import br.com.erp.app.unit.users.builders.domain.AbilityGroupFakeBuilder;
import br.com.erp.app.unit.users.builders.fileproperties.GroupFilePropertiesFakeBuilder;
import br.com.erp.app.users.application.core.domain.AbilityGroup;
import br.com.erp.app.users.application.core.usecases.abilitygroups.CreateAbilityGroupUseCase;
import br.com.erp.app.users.application.ports.out.abilitygroups.CreateAbilityGroupAdapterPort;
import br.com.erp.app.users.application.ports.out.abilitygroups.FindAbilityGroupAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CreateAbilityGroupUseCaseTest {
    @InjectMocks
    private CreateAbilityGroupUseCase createAbilityGroupUseCase;
    @Mock
    private FindAbilityGroupAdapterPort findAbilityGroupAdapterPort;
    @Mock
    private CreateAbilityGroupAdapterPort createAbilityGroupAdapterPort;

    @DisplayName("should successfully create group ability")
    @Test
    void create() {
        var abilityFilePropertiesFakeBuilder = new GroupFilePropertiesFakeBuilder().getFake();
        var abilityGroup = new AbilityGroupFakeBuilder().getFake();
        when(findAbilityGroupAdapterPort.findAbilityGroupByCode(abilityFilePropertiesFakeBuilder.getCode())).thenReturn(any(AbilityGroup.class));
        when(createAbilityGroupAdapterPort.create(abilityGroup)).thenReturn(abilityGroup);

        var abilityGroupResult = createAbilityGroupUseCase.findOrCreate(abilityFilePropertiesFakeBuilder);
        verify(createAbilityGroupAdapterPort, times(1)).create(any(AbilityGroup.class));
        assertNotNull(abilityGroupResult);
    }

    @DisplayName("should return group ability if it already exists")
    @Test
    void returnsGroupAbilityIfItAlreadyExists() {
        var abilityFilePropertiesFakeBuilder = new GroupFilePropertiesFakeBuilder().getFake();
        var abilityGroup = new AbilityGroupFakeBuilder().getFake();
        when(findAbilityGroupAdapterPort.findAbilityGroupByCode(abilityFilePropertiesFakeBuilder.getCode())).thenReturn(abilityGroup);

        var abilityGroupResult = createAbilityGroupUseCase.findOrCreate(abilityFilePropertiesFakeBuilder);
        verify(createAbilityGroupAdapterPort, times(0)).create(any(AbilityGroup.class));
        assertNotNull(abilityGroupResult);
    }
}
