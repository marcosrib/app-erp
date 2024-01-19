package br.com.erp.app.unit.users.application.core.usecases.users;

import br.com.erp.app.common.exceptions.ResourceAlreadyExistsException;
import br.com.erp.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.erp.app.users.application.core.domain.User;
import br.com.erp.app.users.application.core.usecases.users.CreateUserUseCase;
import br.com.erp.app.users.application.ports.out.users.CreateUserAdapterPort;
import br.com.erp.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.erp.app.users.application.ports.out.users.PasswordEncoderAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
    private final String PASSWORD = "123456";
    private final String PASSWORD_ENCODED = "RTIORIT9584598RTUIOJFEOIFRI";
    @InjectMocks
    private CreateUserUseCase createUserUseCase;
    @Mock
    private CreateUserAdapterPort createUserAdapterPort;
    @Mock
    private PasswordEncoderAdapterPort encoder;
    @Mock
    private FindUserAdapterPort findUserAdapterPort;

    @DisplayName("should successfully create user")
    @Test
    void create() {
        var user = new UserFakeBuilder().getFake();
        user.setPassword(PASSWORD);
        when(findUserAdapterPort.findByEmail(anyString())).thenReturn(null);
        when(encoder.encoderPassword(PASSWORD)).thenReturn(PASSWORD_ENCODED);

        createUserUseCase.create(user);

        verify(encoder, times(1)).encoderPassword(PASSWORD);
        verify(findUserAdapterPort, times(1)).findByEmail(anyString());

        var captor = ArgumentCaptor.forClass(User.class);
        verify(createUserAdapterPort, times(1)).create(captor.capture());
        var value = captor.getValue();
        assertEquals(PASSWORD_ENCODED, value.getPassword());
    }

    @DisplayName("should create user with exception")
    @Test
    void createException() {
        var user = new UserFakeBuilder().getFake();
        when(findUserAdapterPort.findByEmail(anyString())).thenReturn(user);

        var exception = assertThrows(ResourceAlreadyExistsException.class, () -> {
            createUserUseCase.create(user);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "email.already.exists";
        assertEquals(expectedMessage, actualMessage);
    }
}