package br.com.somar.app.users.application.ports.out.users;

import br.com.somar.app.users.application.core.domain.User;
public interface CreateUserAdapterPort {
    User create(User user);
}
