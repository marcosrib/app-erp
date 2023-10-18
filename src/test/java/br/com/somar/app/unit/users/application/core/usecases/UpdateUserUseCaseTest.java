package br.com.somar.app.unit.users.application.core.usecases;

import br.com.somar.app.unit.users.builders.domain.ProfileFakeBuilder;
import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.core.usecases.users.UpdateUserUseCase;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.PasswordEncoderAdapterPort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UpdateUserUseCaseTest {
    @InjectMocks
    private UpdateUserUseCase updateUserUseCase;
    @Mock
    private UpdateUserAdapterPort updateUserAdapter;

    @Mock
    private FindUserAdapterPort findUserAdapterPort;

    @Mock
    private FindProfileAdapterPort findProfileAdapterPort;

    @Mock
    private PasswordEncoderAdapterPort passwordEncoderAdapterPort;

    private static final Long USER_ID = 1L;
    private static final String PASSWORD = "123456";
    @DisplayName("should successfully update user with password")
    @Test
    void updateUserWithPassword(){
        var user =  new UserFakeBuilder().getFake();
        var profile = new ProfileFakeBuilder();
        user.setPassword(PASSWORD);
        when(updateUserAdapter.update(user))
                .thenReturn(user);
        when(findUserAdapterPort.findById(anyLong()))
                .thenReturn(user);
        when(findProfileAdapterPort.findProfileBydId(anyLong()))
                .thenReturn(profile.getFake());

        var updatedUser = updateUserUseCase.update(USER_ID, user);
        verify(findUserAdapterPort, times(1)).findById(1L);
        verify(findProfileAdapterPort, times(1)).findProfileBydId(anyLong());
        verify(passwordEncoderAdapterPort, times(1)).encoderPassword(anyString());
        verify(updateUserAdapter, times(1)).update(any(User.class));

        assertNotNull(updatedUser);
        assertEquals(user.getName(), updatedUser.getName());
        assertEquals(user.getEmail(), updatedUser.getEmail());

    }
    @Test
    @DisplayName("should successfully update user is null password")
    void updateUserIsNullPassword(){
        var user =  new UserFakeBuilder().getFake();
        var profile = new ProfileFakeBuilder();
        when(updateUserAdapter.update(user))
                .thenReturn(user);
        when(findUserAdapterPort.findById(anyLong()))
                .thenReturn(user);
        when(findProfileAdapterPort.findProfileBydId(anyLong()))
                .thenReturn(profile.getFake());

        var updatedUser = updateUserUseCase.update(USER_ID, user);
        verify(findUserAdapterPort, times(1)).findById(1L);
        verify(findProfileAdapterPort, times(1)).findProfileBydId(anyLong());
        verify(passwordEncoderAdapterPort, times(0)).encoderPassword(anyString());
        verify(updateUserAdapter, times(1)).update(any(User.class));

        assertNotNull(updatedUser);
        assertEquals(user.getName(), updatedUser.getName());
        assertEquals(user.getEmail(), updatedUser.getEmail());

    }
}
