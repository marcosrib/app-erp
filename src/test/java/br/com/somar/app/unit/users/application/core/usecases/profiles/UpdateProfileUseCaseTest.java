package br.com.erp.app.unit.users.application.core.usecases.profiles;

import br.com.erp.app.unit.users.builders.domain.AbilityFakeBuilder;
import br.com.erp.app.unit.users.builders.domain.ProfileFakeBuilder;
import br.com.erp.app.users.application.core.domain.Profile;
import br.com.erp.app.users.application.core.usecases.profiles.UpdateProfileUseCase;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.erp.app.users.application.ports.out.profiles.UpdateProfileAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateProfileUseCaseTest {
    @InjectMocks
    private UpdateProfileUseCase updateProfileUseCase;
    @Mock
    private UpdateProfileAdapterPort updateProfileAdapterPort;
    @Mock
    private FindProfileAdapterPort findProfileAdapterPort;

    @DisplayName("should successfully update profile")
    @Test
    void update() {
        var profile = new ProfileFakeBuilder().getFake();
        var profileNew = new ProfileFakeBuilder().getFake();
        var abilities = new AbilityFakeBuilder().getFake(5);
        profileNew.setDescription("description");
        profileNew.setAbilities(abilities);

        when(findProfileAdapterPort.findProfileBydId(1L)).thenReturn(profile);
        updateProfileUseCase.update(profileNew, 1L);

        verify(updateProfileAdapterPort, times(1)).update(profile);
        var captor = ArgumentCaptor.forClass(Profile.class);
        verify(updateProfileAdapterPort, times(1)).update(captor.capture());

        var value = captor.getValue();
        assertEquals(profileNew.getName(), value.getName());
        assertEquals(profileNew.getDescription(), value.getDescription());
        assertEquals(profile.getId(), value.getId());
        assertEquals(5, value.getAbilities().size());
    }
}
