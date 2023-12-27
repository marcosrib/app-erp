package br.com.somar.app.unit.users.adpters.outbound.repositories.users;

import br.com.somar.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.somar.app.unit.users.builders.repositories.entities.UserEntityFakeBuilder;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.adapters.outbound.repositories.users.UpdateUserAdapter;
import br.com.somar.app.users.adapters.outbound.repositories.users.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateUserAdapterTest {

    @InjectMocks
    private UpdateUserAdapter updateUserAdapter;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("should successfully update user")
    public void testShouldUpdateUser() {
        var userFakeEntity = new UserEntityFakeBuilder().getFake();
        var userFake = new UserFakeBuilder().getFake();

        when(userRepository.save(any(UserEntity.class))).thenReturn(userFakeEntity);
        var captor = ArgumentCaptor.forClass(UserEntity.class);
        updateUserAdapter.update(userFake);
        verify(userRepository, Mockito.times(1)).save(captor.capture());

        var userEntityCaptured = captor.getValue();

        assertEquals(userFake.getId(), userEntityCaptured.getId());
        assertEquals(userFake.getName(), userEntityCaptured.getName());
        assertEquals(userFake.isStatus(), userEntityCaptured.getStatus());
        assertEquals(userFake.getPassword(), userEntityCaptured.getPassword());
        assertEquals(userFake.getCreatedAt(), userEntityCaptured.getCreatedAt());
        assertEquals(userFake.getProfiles().stream().findAny().get().getId(), userEntityCaptured.getProfiles().stream().findAny().get().getId());
    }

}
