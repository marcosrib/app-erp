package br.com.somar.app.unit.users.application.core.usecases.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.users.application.core.usecases.users.FindUserUseCase;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindUserUseCaseTest {
    @InjectMocks
    private FindUserUseCase findUserUseCase;
    @Mock
    private FindUserAdapterPort findUserAdapterPort;

    @Test
    @DisplayName("should successfully get user by id")
    void getUsersWithPagination() {
        var user = new UserFakeBuilder().getFake();

        when(findUserAdapterPort.findById(anyLong()))
                .thenReturn(user);

        var resultPage = findUserUseCase.findUserById(1L);
        assertNotNull(resultPage);
        verify(findUserAdapterPort, times(1)).findById(1L);

    }
}
