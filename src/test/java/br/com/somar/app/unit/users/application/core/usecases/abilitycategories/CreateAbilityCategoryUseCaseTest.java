package br.com.somar.app.unit.users.application.core.usecases.abilitycategories;

import br.com.somar.app.unit.users.builders.domain.AbilityCategoryFakeBuilder;
import br.com.somar.app.unit.users.builders.fileproperties.AbilityFilePropertiesFakeBuilder;
import br.com.somar.app.users.adapters.outbound.fileproperties.AbilityFileProperties;
import br.com.somar.app.users.application.core.domain.AbilityCategory;
import br.com.somar.app.users.application.core.usecases.abilitycategories.CreateAbilityCategoryUseCase;
import br.com.somar.app.users.application.ports.out.abilitycategories.CreateAbilityCategoryAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitycategories.FindAbilityCategoryAdapterPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateAbilityCategoryUseCaseTest {
    @InjectMocks
    private CreateAbilityCategoryUseCase createAbilityCategoryUseCase;
    @Mock
    private FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort;
    @Mock
    private CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort;

    private List<AbilityFileProperties> abilityFilePropertiesFakeBuilder;

    private Set<AbilityCategory> abilityCategories;
    private final String ABILITY_CATEGORY_CODE = "CODE";

    @BeforeEach
    void setup() {
        abilityFilePropertiesFakeBuilder = new AbilityFilePropertiesFakeBuilder().getFake(1);
        abilityCategories = new AbilityCategoryFakeBuilder().getFake(1);
    }

    @DisplayName("should successfully create ability category existing")
    @Test
    void createAbilityExisting() {

        when(findAbilityCategoryAdapterPort.findCodeByIn(anyList())).thenReturn(abilityCategories);
        when(createAbilityCategoryAdapterPort.createAll(anySet())).thenReturn(abilityCategories);

        var abilityCategoriesRes = createAbilityCategoryUseCase.findOrCreate(abilityFilePropertiesFakeBuilder);

        verify(createAbilityCategoryAdapterPort, times(1)).createAll(anySet());
        assertTrue(abilityCategoriesRes.size() > 0);
    }

    @DisplayName("should successfully create ability category is not existing")
    @Test
    void createAbilityIsNotExisting() {

        when(findAbilityCategoryAdapterPort.findCodeByIn(anyList())).thenReturn(Collections.emptySet());
        when(createAbilityCategoryAdapterPort.createAll(anySet())).thenReturn(abilityCategories);

        var abilityCategoriesRes = createAbilityCategoryUseCase.findOrCreate(abilityFilePropertiesFakeBuilder);

        verify(createAbilityCategoryAdapterPort, times(1)).createAll(anySet());
        assertTrue(abilityCategoriesRes.size() > 0);
    }

    @DisplayName("should only return ability category if it already exists registered")
    @Test
    void returnAbilityCategoryIfItAlreadyExistsRegistered() {
        var abilityFilePropertiesFakeBuilder = new AbilityFilePropertiesFakeBuilder().getFake();
        abilityFilePropertiesFakeBuilder.setCode(ABILITY_CATEGORY_CODE);
        var abilityCategories = new AbilityCategoryFakeBuilder().getFake();
        abilityCategories.setCode(ABILITY_CATEGORY_CODE);

        when(findAbilityCategoryAdapterPort.findCodeByIn(anyList())).thenReturn(Set.of(abilityCategories));

        var abilityCategoriesRes = createAbilityCategoryUseCase.findOrCreate(List.of(abilityFilePropertiesFakeBuilder));

        assertTrue(abilityCategoriesRes.size() > 0);
    }
}
