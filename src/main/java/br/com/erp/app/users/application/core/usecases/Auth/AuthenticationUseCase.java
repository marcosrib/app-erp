package br.com.erp.app.users.application.core.usecases.Auth;

import br.com.erp.app.users.application.core.domain.Auth;
import br.com.erp.app.users.application.ports.in.authentication.AuthenticationUseCasePort;
import br.com.erp.app.users.application.ports.out.auth.AuthenticationAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUseCase implements AuthenticationUseCasePort {
    private final AuthenticationAdapterPort authenticationAdapterPort;

    public AuthenticationUseCase(AuthenticationAdapterPort authenticationAdapterPort) {
        this.authenticationAdapterPort = authenticationAdapterPort;
    }

    @Override
    public Auth auth(Auth auth) {
        return authenticationAdapterPort.authenticate(auth);
    }

}
