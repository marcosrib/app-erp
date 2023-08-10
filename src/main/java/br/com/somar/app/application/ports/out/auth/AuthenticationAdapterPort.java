package br.com.somar.app.application.ports.out.auth;

import br.com.somar.app.application.domain.Auth;
import org.springframework.security.core.userdetails.UserDetails;
public interface AuthenticationAdapterPort {
    UserDetails loadUserByUsername(String email);
    Auth authenticate(Auth auth);
}