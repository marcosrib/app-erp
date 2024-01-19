package br.com.erp.app.users.application.core.usecases.users;

import br.com.erp.app.users.application.core.domain.PageDomain;
import br.com.erp.app.users.application.core.domain.PageableRequestDomain;
import br.com.erp.app.users.application.core.domain.User;
import br.com.erp.app.users.application.ports.in.users.FindPaginationUserUseCasePort;
import br.com.erp.app.users.application.ports.out.users.FindPaginationUserAdapterPort;

public class FindPaginationUserUseCase implements FindPaginationUserUseCasePort {

    private final FindPaginationUserAdapterPort findPaginationUserAdapterPort;

    public FindPaginationUserUseCase(FindPaginationUserAdapterPort findPaginationUserAdapterPort) {
        this.findPaginationUserAdapterPort = findPaginationUserAdapterPort;
    }

    @Override
    public PageDomain<User> getUsersWithPaginationAndFilter(User user, PageableRequestDomain pageableRequest) {
        return findPaginationUserAdapterPort.findUsersWithPagination(user, pageableRequest);
    }
}
