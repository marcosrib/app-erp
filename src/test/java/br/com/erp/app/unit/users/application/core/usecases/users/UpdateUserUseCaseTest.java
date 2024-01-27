package br.com.erp.app.unit.users.application.core.usecases.users;

import br.com.erp.app.unit.users.builders.domain.ProfileFakeBuilder;
import br.com.erp.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.erp.app.users.application.core.domain.User;
import br.com.erp.app.users.application.core.usecases.users.UpdateUserUseCase;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.erp.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.erp.app.users.application.ports.out.users.PasswordEncoderAdapterPort;
import br.com.erp.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateUserUseCaseTest {
    private static final Long USER_ID = 1L;
    private static final String PASSWORD = "123456";
    private static final String PASSWORD_ENCODED = "dsfjdsjkdsjgkjkl";
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

    @DisplayName("should successfully update user with password")
    @Test
    void updateUserWithPassword() {
        var userNew = new UserFakeBuilder().getFake();
        var userOld = new UserFakeBuilder().getFake();
        var profile = new ProfileFakeBuilder();
        userNew.setPassword(PASSWORD);
        doNothing().when(updateUserAdapter).update(any(User.class));
        when(findUserAdapterPort.findById(anyLong()))
                .thenReturn(userOld);
        when(findProfileAdapterPort.findProfileBydId(anyLong()))
                .thenReturn(profile.getFake());
        when(passwordEncoderAdapterPort.encoderPassword(PASSWORD))
                .thenReturn(PASSWORD_ENCODED);
        userNew.setStatus(false);

        updateUserUseCase.update(USER_ID, userNew);

        verify(findUserAdapterPort, times(1)).findById(1L);
        verify(findProfileAdapterPort, times(1)).findProfileBydId(anyLong());
        verify(passwordEncoderAdapterPort, times(1)).encoderPassword(PASSWORD);
        var captor = ArgumentCaptor.forClass(User.class);
        verify(updateUserAdapter, times(1)).update(captor.capture());

        var userCaptured = captor.getValue();

        assertEquals(userNew.getName(), userCaptured.getName());
        assertEquals(userNew.getEmail(), userCaptured.getEmail());
        assertEquals(PASSWORD_ENCODED, userCaptured.getPassword());
        assertEquals(userNew.isStatus(), userCaptured.isStatus());
    }

    @Test
    @DisplayName("should successfully update user is null password")
    void updateUserIsNullPassword() {
        var user = new UserFakeBuilder().getFake();
        var profile = new ProfileFakeBuilder();
        doNothing().when(updateUserAdapter).update(user);
        when(findUserAdapterPort.findById(anyLong()))
                .thenReturn(user);
        when(findProfileAdapterPort.findProfileBydId(anyLong()))
                .thenReturn(profile.getFake());
        updateUserUseCase.update(USER_ID, user);
        verify(findUserAdapterPort, times(1)).findById(1L);
        verify(findProfileAdapterPort, times(1)).findProfileBydId(anyLong());
        verify(passwordEncoderAdapterPort, times(0)).encoderPassword(anyString());
        verify(updateUserAdapter, times(1)).update(any(User.class));


    }
}
