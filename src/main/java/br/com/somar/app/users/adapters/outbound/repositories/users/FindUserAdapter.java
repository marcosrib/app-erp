package br.com.somar.app.users.adapters.outbound.repositories.users;


import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.common.exceptions.ResourceNotFoundException;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
public class FindUserAdapter implements FindUserAdapterPort {
    private final UserRepository userRepository;

    public FindUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        var userEntity = userRepository.findByEmail(email);
        if (ObjectUtils.isNotEmpty(userEntity)) {
            User.convertUserEntitytoUser(userEntity);
        }
        return null;
    }

    @Override
    public User findById(Long id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user.not.exists"));
        return User.convertUserEntitytoUser(userEntity);
    }

}