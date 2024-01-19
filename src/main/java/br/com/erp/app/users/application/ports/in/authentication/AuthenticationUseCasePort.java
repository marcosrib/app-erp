package br.com.erp.app.users.application.ports.in.authentication;

import br.com.erp.app.users.application.core.domain.Auth;

public interface AuthenticationUseCasePort {
    Auth auth(Auth auth);
}
