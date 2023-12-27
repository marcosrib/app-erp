package br.com.somar.app.unit.users.application.core.usecases.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.core.usecases.users.UpdateUserStatusUseCase;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserStatusAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UpdateUserStatusUseCaseTest {
    @InjectMocks
    private UpdateUserStatusUseCase updateUserStatusUseCase;
    @Mock
    private UpdateUserStatusAdapterPort updateUserStatusAdapterPort;
    @Mock
    private FindUserAdapterPort findUserAdapterPort;

    @Test
    @DisplayName("should successfully update user status")
    void updateStatus() {
        var user = new UserFakeBuilder().getFake();
        user.setStatus(false);
        when(findUserAdapterPort.findById(anyLong())).thenReturn(user);
        doNothing().when(updateUserStatusAdapterPort).updateStatus(user);
        updateUserStatusUseCase.updateStatus(anyLong(), true);

        var captor =  ArgumentCaptor.forClass(User.class);
        verify(findUserAdapterPort, times(1)).findById(anyLong());

        verify(updateUserStatusAdapterPort, times(1)).updateStatus(captor.capture());

        var value = captor.getValue();
        assertTrue(value.isStatus());
    }
}
