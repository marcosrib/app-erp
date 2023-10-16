package br.com.somar.app.unit.users.adpters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.adapters.outbound.repositories.profiles.ProfileRepository;
import br.com.somar.app.users.adapters.outbound.repositories.users.UpdateUserAdapter;
import br.com.somar.app.users.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.core.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateUserAdapterTest {

    @InjectMocks
    private UpdateUserAdapter updateUserAdapter;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ProfileRepository profileRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldUpdateUser() {
        Long userId = 1L;
        UserEntity existingUser = new UserEntity();
        existingUser.setId(userId);
        existingUser.setEmail("existing@example.com");
        existingUser.setProfiles(new HashSet<>());

        Long profileId = 1L;
        ProfileEntity existingProfile = new ProfileEntity();
        existingProfile.setId(profileId);

        // Simule o comportamento dos repositórios
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.of(existingProfile));

        // Simule a senha codificada
        String encodedPassword = "encodedPassword";
        Mockito.when(passwordEncoder.encode("newPassword")).thenReturn(encodedPassword);

        // Crie um objeto User para atualização
        User userToUpdate = new User();
        userToUpdate.setPassword("newPassword");
        userToUpdate.setProfiles(new HashSet<>());
        userToUpdate.getProfiles().add(new Profile(profileId, "New Profile"));
       // Mockito.when(userRepository.save(existingUser)).thenReturn(Optional.of(existingUser));
        // Chame o método de atualização
        User updatedUser = updateUserAdapter.update(userToUpdate, userId);

        // Verifique se o usuário foi atualizado corretamente
        assertAll(
                () -> assertEquals(userId, updatedUser.getId()),
                () -> assertEquals("existing@example.com", updatedUser.getEmail()),
                () -> assertEquals(encodedPassword, updatedUser.getPassword()),
                () -> assertEquals(1, updatedUser.getProfiles().size())
        );
    }
}
