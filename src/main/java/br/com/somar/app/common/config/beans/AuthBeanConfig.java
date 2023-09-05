package br.com.somar.app.common.config.beans;

import br.com.somar.app.adapters.outbound.jwt.JwtAdapter;
import br.com.somar.app.application.ports.in.authentication.AuthenticationUseCasePort;
import br.com.somar.app.application.ports.in.authentication.RefreshTokenUseCasePort;
import br.com.somar.app.application.ports.out.auth.AuthenticationAdapterPort;
import br.com.somar.app.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.application.usecases.Auth.AuthenticationUseCase;
import br.com.somar.app.application.usecases.Auth.RefreshTokenUseCase;
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
