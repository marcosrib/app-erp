package br.com.somar.app.users.application.ports.out.auth;

import br.com.somar.app.users.application.core.domain.Auth;

public interface AuthenticationAdapterPort {
    Auth authenticate(Auth auth);
    Auth findUserWithProfileAndAuthoritiesByEmail(String email);
}