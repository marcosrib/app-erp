package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.common.exceptions.ResourceAlreadyExistsException;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.CreateUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.PasswordEncoderAdapterPort;
import org.apache.commons.lang3.ObjectUtils;

public class CreateUserUseCase implements CreateUserUseCasePort {

    private final CreateUserAdapterPort createUserAdapterPort;
    private final PasswordEncoderAdapterPort encoder;
    private final FindUserAdapterPort findUserAdapterPort;

    public CreateUserUseCase(CreateUserAdapterPort createUserAdapterPort,
                             PasswordEncoderAdapterPort encoder,
                             FindUserAdapterPort findUserAdapterPort) {
        this.createUserAdapterPort = createUserAdapterPort;
        this.encoder = encoder;
        this.findUserAdapterPort = findUserAdapterPort;
    }

    @Override
    public void create(User user) {
        User userRes = findUserAdapterPort.findByEmail(user.getEmail());
        if (ObjectUtils.isNotEmpty(userRes)) {
            throw new ResourceAlreadyExistsException("email.already.exists");
        }
        String encryptPassword = encoder.encoderPassword(user.getPassword());
        user.setPassword(encryptPassword);
        createUserAdapterPort.create(user);
    }
}
