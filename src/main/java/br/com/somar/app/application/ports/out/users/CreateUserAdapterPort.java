package br.com.somar.app.application.ports.out.users;

import br.com.somar.app.application.domain.User;
public interface CreateUserAdapterPort {
    User create(User user);
}
