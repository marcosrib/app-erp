package br.com.somar.app.unit.users.application.core.usecases.profiles;

import br.com.somar.app.unit.users.builders.domain.ProfileFakeBuilder;
import br.com.somar.app.users.application.core.usecases.profiles.FindAllProfileUseCase;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class FindAllProfileUseCaseTest {
    @InjectMocks
    private FindAllProfileUseCase findAllProfileUseCase;
    @Mock
    private FindProfileAdapterPort findProfileAdapterPort;
    @Test
    @DisplayName("should successfully get all profile")
    void getAllProfiles() {
        var profiles = new ProfileFakeBuilder().getFake(5);

        when(findProfileAdapterPort.getAllProfiles())
                .thenReturn(profiles);

        var result = findAllProfileUseCase.getAllProfiles();
        assertNotNull(result);
        assertEquals(5, result.size());
        verify(findProfileAdapterPort, times(1)).getAllProfiles();

    }
}
