package br.com.somar.app.unit.users.adpters.outbound.repositories.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.unit.users.builders.repositories.entities.UserFakeEntityBuilder;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.adapters.outbound.repositories.users.CreateUserAdapter;
import br.com.somar.app.users.adapters.outbound.repositories.users.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
public class CreateUserAdapterTest {

    @InjectMocks
    private CreateUserAdapter createUserAdapter;

    @Mock
    private UserRepository userRepository;
    @Test
    @DisplayName("should successfully create user")
    public void testShouldCreateUser() {
        var userFakeEntity = new UserFakeEntityBuilder().getFake();
        var userFake = new UserFakeBuilder().getFake();

        when(userRepository.save(any(UserEntity.class))).thenReturn(userFakeEntity);
        var captor =  ArgumentCaptor.forClass(UserEntity.class);
        createUserAdapter.create(userFake);
        verify(userRepository, Mockito.times(1)).save(captor.capture());

        var userEntityCaptured = captor.getValue();

        assertEquals(userEntityCaptured.getId(), userFake.getId());
        assertEquals(userEntityCaptured.getName(), userFake.getName());
        assertEquals(userEntityCaptured.getStatus(), userFake.isStatus());
        assertEquals(userEntityCaptured.getPassword(), userFake.getPassword());
        assertEquals(userEntityCaptured.getCreatedAt(), userFake.getCreatedAt());
        assertEquals(userEntityCaptured.getProfiles().stream().findAny().get().getId(), userFake.getProfiles().stream().findAny().get().getId());
    }
}
