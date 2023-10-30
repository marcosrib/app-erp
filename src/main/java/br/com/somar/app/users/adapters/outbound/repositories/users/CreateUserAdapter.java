package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.CreateUserAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdapter  implements CreateUserAdapterPort {

    private final UserRepository userRepository;

    public CreateUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User create(User user) {
        UserEntity resUserEntity = userRepository.save(UserEntityMapper.convertUserToEntity(user));
        return User.convertUserEntitytoUser(resUserEntity);
    }
}
