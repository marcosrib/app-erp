package br.com.erp.app.common.config.beans;

import br.com.erp.app.users.adapters.outbound.jwt.JwtAdapter;
import br.com.erp.app.users.application.core.usecases.Auth.AuthenticationUseCase;
import br.com.erp.app.users.application.core.usecases.Auth.RefreshTokenUseCase;
import br.com.erp.app.users.application.ports.in.authentication.AuthenticationUseCasePort;
import br.com.erp.app.users.application.ports.in.authentication.RefreshTokenUseCasePort;
import br.com.erp.app.users.application.ports.out.auth.AuthenticationAdapterPort;
import br.com.erp.app.users.application.ports.out.users.FindUserAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthBeanConfig {

    @Bean
    public AuthenticationUseCasePort authenticationUseCasePort(AuthenticationAdapterPort authenticationAdapterPort) {
        return new AuthenticationUseCase(authenticationAdapterPort);
    }

    @Bean
    public RefreshTokenUseCasePort refreshTokenUseCasePort(FindUserAdapterPort findUserAdapterPort, JwtAdapter jwtAdapter) {
        return new RefreshTokenUseCase(jwtAdapter, findUserAdapterPort);
    }
}
