package br.com.erp.app.users.application.ports.out.users;

import br.com.erp.app.users.application.core.domain.PageDomain;
import br.com.erp.app.users.application.core.domain.PageableRequestDomain;
import br.com.erp.app.users.application.core.domain.User;

public interface FindPaginationUserAdapterPort {
    PageDomain<User> findUsersWithPagination(User user, PageableRequestDomain pageable);
}
