package br.com.somar.app.users.application.ports.in.users;

import br.com.somar.app.users.application.core.domain.User;

public interface FindUserUseCasePort {
    User findUserById(Long id);
}
