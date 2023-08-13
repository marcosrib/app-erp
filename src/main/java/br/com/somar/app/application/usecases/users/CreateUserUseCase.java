package br.com.somar.app.application.usecases.users;

import br.com.somar.app.application.domain.User;
import br.com.somar.app.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.application.ports.out.users.CreateUserAdapterPort;
import br.com.somar.app.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.exceptions.ResourceAlreadyExistsException;
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
        if (existingUser.isPresent()) {
            throw new ResourceAlreadyExistsException("email.already.exists");
        }
        String encryptPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptPassword);
        return createUserAdapterPort.create(user);
    }
}
