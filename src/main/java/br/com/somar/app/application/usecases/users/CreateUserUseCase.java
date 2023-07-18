package br.com.somar.app.application.usecases.users;

import br.com.somar.app.application.domain.User;
import br.com.somar.app.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.application.ports.out.users.CreateUserAdapterPort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserUseCase implements CreateUserUseCasePort {

    private final CreateUserAdapterPort createUserAdapterPort;
    private final PasswordEncoder encoder;

    public CreateUserUseCase(CreateUserAdapterPort createUserAdapterPort, PasswordEncoder encoder) {
        this.createUserAdapterPort = createUserAdapterPort;
        this.encoder = encoder;
    }
    @Override
    public User create(User user) {

        String encryptPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptPassword);
        return createUserAdapterPort.create(user);
    }
}
