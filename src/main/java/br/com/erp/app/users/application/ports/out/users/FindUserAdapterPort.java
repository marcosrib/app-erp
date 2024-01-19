package br.com.erp.app.users.application.ports.out.users;

import br.com.erp.app.users.application.core.domain.User;

public interface FindUserAdapterPort {
    User findByEmail(String email);

    User findById(Long id);

}
