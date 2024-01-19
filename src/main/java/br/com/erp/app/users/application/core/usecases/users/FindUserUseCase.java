package br.com.erp.app.users.application.core.usecases.users;

import br.com.erp.app.users.application.core.domain.User;
import br.com.erp.app.users.application.ports.in.users.FindUserUseCasePort;
import br.com.erp.app.users.application.ports.out.users.FindUserAdapterPort;

public class FindUserUseCase implements FindUserUseCasePort {
    private final FindUserAdapterPort findUserAdapterPort;

    public FindUserUseCase(FindUserAdapterPort findUserAdapterPort) {
        this.findUserAdapterPort = findUserAdapterPort;
    }

    @Override
    public User findUserById(Long id) {
        return findUserAdapterPort.findById(id);
    }
}
