package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.UpdateUserStatusAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserStatusAdapter implements UpdateUserStatusAdapterPort {

    private final UserRepository userRepository;

    public UpdateUserStatusAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateStatus(User user) {
    userRepository.save(UserEntityMapper.convertUserToEntity(user));
    }
}
