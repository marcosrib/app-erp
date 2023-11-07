package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.UpdateUserStatusUseCasePort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserStatusAdapterPort;

public class UpdateUserStatusUseCase implements UpdateUserStatusUseCasePort {
    private final FindUserAdapterPort findUserAdapterPort;
    private final UpdateUserStatusAdapterPort updateUserStatusAdapterPort;
    public UpdateUserStatusUseCase(FindUserAdapterPort findUserAdapterPort, UpdateUserStatusAdapterPort updateUserStatusAdapterPort) {
        this.findUserAdapterPort = findUserAdapterPort;
        this.updateUserStatusAdapterPort = updateUserStatusAdapterPort;
    }

    @Override
    public void updateStatus(Long userId, boolean status) {
        User user = findUserAdapterPort.findById(userId);
        user.setStatus(status);
        updateUserStatusAdapterPort.updateStatus(user);
    }
}
