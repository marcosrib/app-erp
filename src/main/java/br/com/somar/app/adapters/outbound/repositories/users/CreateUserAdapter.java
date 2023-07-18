package br.com.somar.app.adapters.outbound.repositories.users;

import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.application.domain.User;
import br.com.somar.app.application.ports.out.users.CreateUserAdapterPort;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class CreateUserAdapter  implements CreateUserAdapterPort {

    private final UserRepository userRepository;

    public CreateUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        Set<ProfileEntity> profiles = new HashSet<>();
        user.getProfiles().forEach(p -> {
            ProfileEntity profileEntity = new ProfileEntity();
            profileEntity.setId(p.getId());
            profileEntity.setName(p.getName());
            profiles.add(profileEntity);
        });

        UserEntity userEntity = UserEntity
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .profiles(profiles)
                .build();
        UserEntity resUserEntity = userRepository.save(userEntity);
        return User.convertUserEntitytoUser(resUserEntity);
    }
}
