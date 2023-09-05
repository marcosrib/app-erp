package br.com.somar.app.application.ports.in.authentication;

import br.com.somar.app.application.domain.Auth;
public interface AuthenticationUseCasePort {
    Auth auth(Auth auth);
}
