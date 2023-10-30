package br.com.somar.app.users.application.ports.in.authentication;

import br.com.somar.app.users.application.core.domain.Auth;

public interface AuthenticationUseCasePort {
    Auth auth(Auth auth);
}
