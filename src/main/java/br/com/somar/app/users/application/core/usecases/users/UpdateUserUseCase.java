package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.common.exceptions.ResourceAlreadyExistsException;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.UpdateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UpdateUserUseCase implements UpdateUserUseCasePort {
    private final UpdateUserAdapterPort updateUserAdapterPort;
    private final FindUserAdapterPort findUserAdapterPort;
    private final PasswordEncoder encoder;
    public UpdateUserUseCase(UpdateUserAdapterPort updateUserAdapterPort,
                             FindUserAdapterPort findUserAdapterPort, PasswordEncoder encoder) {
        this.updateUserAdapterPort = updateUserAdapterPort;
        this.findUserAdapterPort = findUserAdapterPort;
        this.encoder = encoder;
    }

    @Override
    public User update(Long id, User user) {
        var existingUser = findUserAdapterPort.findById(id);
        if (ObjectUtils.isEmpty(existingUser)) {
            throw new ResourceAlreadyExistsException("email.not.exists");
        }
        if(ObjectUtils.isEmpty(user.getPassword())) {
            user.setPassword(existingUser.getPassword());
        }
        if(ObjectUtils.isNotEmpty(user.getPassword())) {
            String encryptPassword = encoder.encode(user.getPassword());
            user.setPassword(encryptPassword);
        }
        return updateUserAdapterPort.update(user);
    }
}
