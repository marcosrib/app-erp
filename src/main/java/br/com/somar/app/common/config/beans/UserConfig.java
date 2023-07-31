package br.com.somar.app.common.config.beans;

import br.com.somar.app.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.application.ports.out.users.CreateUserAdapterPort;
import br.com.somar.app.application.usecases.users.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserUseCasePort createUserUseCasePort(CreateUserAdapterPort createUserAdapterPort, PasswordEncoder encoder) {
        return new CreateUserUseCase(createUserAdapterPort, encoder);
    }
}
