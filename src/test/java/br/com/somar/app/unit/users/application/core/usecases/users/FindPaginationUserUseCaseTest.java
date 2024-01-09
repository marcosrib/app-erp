package br.com.somar.app.unit.users.application.core.usecases.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.users.application.core.domain.PageDomain;
import br.com.somar.app.users.application.core.domain.PageableRequestDomain;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.core.usecases.users.FindPaginationUserUseCase;
import br.com.somar.app.users.application.ports.out.users.FindPaginationUserAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindPaginationUserUseCaseTest {
    @InjectMocks
    private FindPaginationUserUseCase findPaginationUserUseCase;
    @Mock
    private FindPaginationUserAdapterPort findPaginationUserAdapterPort;

    @Test
    @DisplayName("should successfully get user pagination")
    void getUsersWithPagination() {
        User filterUser = new User();
        PageableRequestDomain pageableRequest = new PageableRequestDomain(0, 10);
        PageDomain<User> expectedPage = new PageDomain<>();
        var users = new UserFakeBuilder().getFake(5);

        expectedPage.data(users);
        expectedPage.totalElements(5L);

        when(findPaginationUserAdapterPort.findUsersWithPagination(any(User.class), any(PageableRequestDomain.class)))
                .thenReturn(expectedPage);

        var resultPage = findPaginationUserUseCase.getUsersWithPaginationAndFilter(filterUser, pageableRequest);

        assertNotNull(resultPage);
        assertEquals(expectedPage, resultPage);
        assertEquals(expectedPage.getData(), resultPage.getData());

        verify(findPaginationUserAdapterPort, times(1)).findUsersWithPagination(filterUser, pageableRequest);

    }
}
