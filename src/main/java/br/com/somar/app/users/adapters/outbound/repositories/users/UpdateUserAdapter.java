package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.common.exceptions.ResourceAlreadyExistsException;
import br.com.somar.app.common.exceptions.ResourceNotFoundException;
import br.com.somar.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.adapters.outbound.repositories.profiles.ProfileRepository;
import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UpdateUserAdapter implements UpdateUserAdapterPort {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;
    public UpdateUserAdapter(UserRepository userRepository, PasswordEncoder encoder, PasswordEncoder encoder1, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder1;
        this.profileRepository = profileRepository;
    }

    @Override
    public User update(User user, Long id) {
        var existingUser = userRepository.findById(id)
                .orElseThrow(() ->  new ResourceAlreadyExistsException("email.not.exists"));
        if(ObjectUtils.isNotEmpty(user.getPassword())) {
            String encryptPassword = encoder.encode(user.getPassword());
            user.setPassword(encryptPassword);
        }
        existingUser.setProfiles(new HashSet<>());
        existingUser.getProfiles().add(verifyProfileExists(user.getProfiles()));
        UserEntity userEntity = userRepository.save(UserEntityMapper.convertUserToEntityUpdate(user, existingUser));
        return User.convertUserEntitytoUser(userEntity);
    }

    private ProfileEntity verifyProfileExists(Set<Profile> profiles) {
        Optional<Profile> firstProfile = profiles.stream()
                .findFirst();
        var profileId =  firstProfile.get().getId();
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("profile.not.found"));
    }
}
