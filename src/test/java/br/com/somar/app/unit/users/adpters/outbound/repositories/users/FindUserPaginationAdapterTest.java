package br.com.somar.app.unit.users.adpters.outbound.repositories.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.unit.users.builders.repositories.entities.UserEntityFakeBuilder;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.adapters.outbound.repositories.users.FindPaginationUserAdapter;
import br.com.somar.app.users.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.users.application.core.domain.PageDomain;
import br.com.somar.app.users.application.core.domain.PageableRequestDomain;
import br.com.somar.app.users.application.core.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class FindUserPaginationAdapterTest {
    @InjectMocks
    private FindPaginationUserAdapter findPaginationUserAdapter;
    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("should should find users with pagination")
    void findUsersWithPagination() {

        var user = new UserFakeBuilder().getFake();
        user.setEmail(null);
        PageableRequestDomain pageable = new PageableRequestDomain(1, 2);
        Page<UserEntity> userEntityPage = mock(Page.class);

        var userEntityList = new UserEntityFakeBuilder().getFake(10);

        when(userEntityPage.getContent()).thenReturn(userEntityList);
        when(userEntityPage.getTotalPages()).thenReturn(2);
        when(userEntityPage.getTotalElements()).thenReturn(10L);
        when(userEntityPage.getNumber()).thenReturn(0);
        when(userRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(userEntityPage);
        when(userRepository.findUserWithProfilesByIn(userEntityPage.getContent())).thenReturn(userEntityList);

        PageDomain<User> result = findPaginationUserAdapter.findUsersWithPagination(user, pageable);

        assertEquals(2, result.getTotalPages());
        assertEquals(10, result.getTotalElements());
        assertEquals(1, result.getCurrentPage());

        verify(userRepository).findAll(any(Specification.class), any(Pageable.class));
        var captor = ArgumentCaptor.forClass(List.class);
        verify(userRepository).findUserWithProfilesByIn(captor.capture());
        var listUserIds = captor.getValue();
        assertTrue(listUserIds.size() == 10);
    }

    @Test
    @DisplayName("should find users with pagination and filter")
    void findUsersWithPaginationAndFilter() {

        var user = new UserFakeBuilder().getFake();
        PageableRequestDomain pageable = new PageableRequestDomain(1, 2);
        Page<UserEntity> userEntityPage = mock(Page.class);

        var userEntityList = new UserEntityFakeBuilder().getFake(1);

        when(userEntityPage.getContent()).thenReturn(userEntityList);
        when(userEntityPage.getTotalPages()).thenReturn(1);
        when(userEntityPage.getTotalElements()).thenReturn(1L);
        when(userEntityPage.getNumber()).thenReturn(0);
        when(userRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(userEntityPage);
        when(userRepository.findUserWithProfilesByIn(userEntityPage.getContent())).thenReturn(userEntityList);

        PageDomain<User> result = findPaginationUserAdapter.findUsersWithPagination(user, pageable);

        assertEquals(1, result.getTotalPages());
        assertEquals(1, result.getTotalElements());
        assertEquals(1, result.getCurrentPage());

        verify(userRepository, times(1)).findAll(any(Specification.class), any(Pageable.class));
        var captor = ArgumentCaptor.forClass(List.class);
        verify(userRepository, times(1)).findUserWithProfilesByIn(captor.capture());
        var listUserIds = captor.getValue();
        assertTrue(listUserIds.size() == 1);
    }
}
