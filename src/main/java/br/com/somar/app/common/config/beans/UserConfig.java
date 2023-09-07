package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.CreateUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.core.usecases.users.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserUseCasePort createUserUseCasePort(
            CreateUserAdapterPort createUserAdapterPort,
            PasswordEncoder encoder,
            FindUserAdapterPort findUserAdapterPort) {
        return new CreateUserUseCase(createUserAdapterPort, encoder, findUserAdapterPort);
    }
}
