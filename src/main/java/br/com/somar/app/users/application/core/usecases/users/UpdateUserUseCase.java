package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.UpdateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;

public class UpdateUserUseCase implements UpdateUserUseCasePort {
    private final UpdateUserAdapterPort updateUserAdapterPort;

    public UpdateUserUseCase(UpdateUserAdapterPort updateUserAdapterPort) {
        this.updateUserAdapterPort = updateUserAdapterPort;
    }
    @Override
    public User update(Long id, User user) {
        return updateUserAdapterPort.update(user, id);
    }
}
