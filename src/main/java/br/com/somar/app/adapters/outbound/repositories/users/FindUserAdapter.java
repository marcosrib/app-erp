package br.com.somar.app.adapters.outbound.repositories.users;


import br.com.somar.app.application.domain.User;
import br.com.somar.app.application.ports.out.users.FindUserAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class FindUserAdapter implements FindUserAdapterPort {
    private final UserRepository userRepository;

    public FindUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        var userEntity = userRepository.findByEmail(email);
        if(ObjectUtils.isEmpty(userEntity)) {
          return null;
        }
        return User.convertUserEntitytoUser(userEntity);
    }

}