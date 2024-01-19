package br.com.erp.app.users.application.ports.in.users;

import br.com.erp.app.users.application.core.domain.PageDomain;
import br.com.erp.app.users.application.core.domain.PageableRequestDomain;
import br.com.erp.app.users.application.core.domain.User;

public interface FindPaginationUserUseCasePort {
    PageDomain<User> getUsersWithPaginationAndFilter(User user, PageableRequestDomain pageableRequest);
}
