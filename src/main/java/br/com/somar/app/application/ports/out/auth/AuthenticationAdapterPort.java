package br.com.somar.app.application.ports.out.auth;

import br.com.somar.app.application.domain.Auth;
import org.springframework.security.core.userdetails.UserDetails;
public interface AuthenticationAdapterPort {
    Auth authenticate(Auth auth);
    Auth findUserWithProfileAndAuthoritiesByEmail(String email);
}