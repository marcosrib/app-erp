package br.com.erp.app.users.application.ports.out.users;

import br.com.erp.app.users.application.core.domain.User;

public interface CreateUserAdapterPort {
    void create(User user);
}
