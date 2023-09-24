package br.com.somar.app.users.application.ports.out.users;

import br.com.somar.app.users.application.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindPaginationUserAdapterPort {
    Page<User> findUsersWithPagination(User user, Pageable pageable);
}
