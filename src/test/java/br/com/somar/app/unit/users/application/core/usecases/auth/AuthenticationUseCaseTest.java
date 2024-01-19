package br.com.erp.app.unit.users.application.core.usecases.auth;

import br.com.erp.app.unit.users.builders.domain.AuthFakeBuilder;
import br.com.erp.app.users.application.core.usecases.Auth.AuthenticationUseCase;
import br.com.erp.app.users.application.ports.out.auth.AuthenticationAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationUseCaseTest {
    @InjectMocks
    private AuthenticationUseCase authenticationUseCase;
    @Mock
    private AuthenticationAdapterPort authenticationAdapterPort;

    @DisplayName("should successfully authentication")
    @Test
    void authenticate() {
        var auth = new AuthFakeBuilder().getFake();
        when(authenticationAdapterPort.authenticate(auth)).thenReturn(auth);
        authenticationUseCase.auth(auth);
        verify(authenticationAdapterPort, times(1)).authenticate(auth);
    }
}
