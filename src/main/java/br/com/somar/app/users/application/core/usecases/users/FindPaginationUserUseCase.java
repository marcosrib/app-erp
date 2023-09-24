package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.FindPaginationUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.FindPaginationUserAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FindPaginationUserUseCase implements FindPaginationUserUseCasePort {

    private final FindPaginationUserAdapterPort findPaginationUserAdapterPort;

    public FindPaginationUserUseCase(FindPaginationUserAdapterPort findPaginationUserAdapterPort) {
        this.findPaginationUserAdapterPort = findPaginationUserAdapterPort;
    }

    @Override
    public Page<User> getUsersWithPaginationAndFilter(User user, Pageable pageable) {
        return findPaginationUserAdapterPort.findUsersWithPagination(user, pageable);
    }
}
