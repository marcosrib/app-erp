package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.CreateUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.common.exceptions.ResourceAlreadyExistsException;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserUseCase implements CreateUserUseCasePort {

    private final CreateUserAdapterPort createUserAdapterPort;
    private final PasswordEncoder encoder;
    private final FindUserAdapterPort findUserAdapterPort;

    public CreateUserUseCase(CreateUserAdapterPort createUserAdapterPort,
                             PasswordEncoder encoder,
                             FindUserAdapterPort findUserAdapterPort) {
        this.createUserAdapterPort = createUserAdapterPort;
        this.encoder = encoder;
        this.findUserAdapterPort = findUserAdapterPort;
    }

    @Override
    public User create(User user) {
        var existingUser = findUserAdapterPort.findByEmail(user.getEmail());
        if (ObjectUtils.isNotEmpty(existingUser )) {
            throw new ResourceAlreadyExistsException("email.already.exists");
        }
        String encryptPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptPassword);
        return createUserAdapterPort.create(user);
    }
}
