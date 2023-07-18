package br.com.somar.app.application.ports.in.users;

import br.com.somar.app.application.domain.User;

public interface CreateUserUseCasePort {
    User create(User user);
}
