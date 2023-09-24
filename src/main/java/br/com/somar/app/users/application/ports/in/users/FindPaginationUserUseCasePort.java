package br.com.somar.app.users.application.ports.in.users;

import br.com.somar.app.users.application.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindPaginationUserUseCasePort {
    Page<User> getUsersWithPaginationAndFilter(User user, Pageable pageable);
}
