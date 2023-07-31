package br.com.somar.app.application.usecases;

import br.com.somar.app.application.domain.Auth;
import br.com.somar.app.application.ports.in.AuthenticationUseCasePort;
import br.com.somar.app.application.ports.out.auth.AuthenticationAdapterPort;
import br.com.somar.app.exceptions.PasswordInvalidException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUseCase implements AuthenticationUseCasePort {
    private final AuthenticationAdapterPort authenticationAdapterPort;

    public AuthenticationUseCase(AuthenticationAdapterPort authenticationAdapterPort) {
        this.authenticationAdapterPort = authenticationAdapterPort;
    }

    @Override
    public String auth(Auth auth) {
        System.out.println("dsnlvknkkl");
        String token = authenticationAdapterPort.authenticate(auth);
        if(token == null) {
            throw new PasswordInvalidException("Senha invalida");
        }
        return token;
    }
}
