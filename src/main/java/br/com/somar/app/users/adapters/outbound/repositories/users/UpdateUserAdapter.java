package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserAdapter implements UpdateUserAdapterPort {
   private final UserRepository userRepository;
    public UpdateUserAdapter(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
    }

    @Override
    public User update(User user) {
        var userEntity =  userRepository.save(convertUserIntoEntity(user));
        return User.convertUserEntitytoUser(userEntity);
    }

    private UserEntity convertUserIntoEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getPassword())
                .status(user.isStatus())
                .build();
    }
}
