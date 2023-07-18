package br.com.somar.app.adapters.outbound.repositories.users;


import br.com.somar.app.application.domain.User;
import br.com.somar.app.application.ports.out.users.FindUserAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserAdapter implements FindUserAdapterPort {
    private final UserRepository userRepository;

    public FindUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.of(User.convertUserEntitytoUser(userRepository.findByEmail(email).get()));
    }
}