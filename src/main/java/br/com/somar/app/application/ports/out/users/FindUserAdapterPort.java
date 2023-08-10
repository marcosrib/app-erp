package br.com.somar.app.application.ports.out.users;

import br.com.somar.app.application.domain.User;

import java.util.Optional;
public interface FindUserAdapterPort {
    Optional<User> findByEmail(String email);

}
