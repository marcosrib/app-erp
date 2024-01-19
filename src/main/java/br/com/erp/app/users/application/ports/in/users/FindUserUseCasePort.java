package br.com.erp.app.users.application.ports.in.users;

import br.com.erp.app.users.application.core.domain.User;

public interface FindUserUseCasePort {
    User findUserById(Long id);
}
