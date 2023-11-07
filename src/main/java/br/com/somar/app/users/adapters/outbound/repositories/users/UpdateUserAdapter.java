package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserAdapter implements UpdateUserAdapterPort {
    private final UserRepository userRepository;

    public UpdateUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void update(User user) {
        UserEntity userEntity = UserEntityMapper.convertUserToEntity(user);
        userRepository.save(userEntity);
    }
}
