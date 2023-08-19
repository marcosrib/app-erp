package br.com.somar.app.common.config.beans;

import br.com.somar.app.application.ports.in.AuthenticationUseCasePort;
import br.com.somar.app.application.ports.out.auth.AuthenticationAdapterPort;
import br.com.somar.app.application.usecases.Auth.AuthenticationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthBeanConfig {

    @Bean
    public AuthenticationUseCasePort authenticationUseCasePort(AuthenticationAdapterPort authenticationAdapterPort) {
        return new AuthenticationUseCase(authenticationAdapterPort);
    }
}
