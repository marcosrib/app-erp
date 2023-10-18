package br.com.somar.app.unit.users.adpters.outbound.repositories.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.unit.users.builders.repositories.entities.UserFakeEntityBuilder;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.adapters.outbound.repositories.users.UpdateUserAdapter;
import br.com.somar.app.users.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.users.application.core.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UpdateUserAdapterTest {

    @InjectMocks
    private UpdateUserAdapter updateUserAdapter;

    @Mock
    private UserRepository userRepository;


    @Test
    @DisplayName("should successfully update user")
    public void testShouldUpdateUser() {
         var userFakeEntity = new UserFakeEntityBuilder().getFake();
         var userFake = new UserFakeBuilder().getFake();

        when(userRepository.save(any(UserEntity.class))).thenReturn(userFakeEntity);

        User updatedUser = updateUserAdapter.update(userFake);
        verify(userRepository, Mockito.times(1)).save(any(UserEntity.class));
        assertNotNull(updatedUser);

    }
}
