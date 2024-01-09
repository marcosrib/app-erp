package br.com.somar.app.unit.users.application.core.usecases.profiles;

import br.com.somar.app.unit.users.builders.domain.ProfileFakeBuilder;
import br.com.somar.app.users.application.core.usecases.profiles.CreateProfileUseCase;
import br.com.somar.app.users.application.ports.out.profiles.CreateProfileAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateProfileUseCaseTest {
    @InjectMocks
    private CreateProfileUseCase createProfileUseCase;
    @Mock
    private CreateProfileAdapterPort createProfileAdapterPort;

    @DisplayName("should successfully create profile")
    @Test
    void create() {
        var profile = new ProfileFakeBuilder().getFake();
        createProfileUseCase.create(profile);
        verify(createProfileAdapterPort, times(1)).create(profile);
    }
}
