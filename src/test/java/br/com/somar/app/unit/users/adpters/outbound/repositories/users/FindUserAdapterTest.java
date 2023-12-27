package br.com.somar.app.unit.users.adpters.outbound.repositories.users;

import br.com.somar.app.common.exceptions.ResourceNotFoundException;
import br.com.somar.app.unit.users.builders.repositories.entities.UserEntityFakeBuilder;
import br.com.somar.app.users.adapters.outbound.repositories.users.FindUserAdapter;
import br.com.somar.app.users.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.users.application.core.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindUserAdapterTest {
    @InjectMocks
    private FindUserAdapter findUserAdapter;
    @Mock
    private UserRepository userRepository;
    @Test
    @DisplayName("should successfully find user by id")
    public void testFindUserById() {
        var userFakeEntity = new UserEntityFakeBuilder().getFake();
        when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(userFakeEntity));

        User user = findUserAdapter.findById(anyLong());
        verify(userRepository, Mockito.times(1)).findById(anyLong());
        assertNotNull(user);
    }

    @Test
    @DisplayName("should find user by id not found exception")
    public void testFindUserByIdNotFoundException() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());;

        assertThrows(ResourceNotFoundException.class, () -> {
            findUserAdapter.findById(anyLong());
        });
    }
}
