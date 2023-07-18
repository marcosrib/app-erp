package br.com.somar.app.application.ports.in;

import br.com.somar.app.application.domain.Auth;

public interface AuthenticationUseCasePort {
    String auth(Auth auth);
}
