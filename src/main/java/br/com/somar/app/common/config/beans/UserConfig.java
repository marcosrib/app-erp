package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.core.usecases.users.CreateUserUseCase;
import br.com.somar.app.users.application.core.usecases.users.FindPaginationUserUseCase;
import br.com.somar.app.users.application.core.usecases.users.UpdateUserUseCase;
import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.application.ports.in.users.FindPaginationUserUseCasePort;
import br.com.somar.app.users.application.ports.in.users.UpdateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.ports.out.users.*;
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
    @Bean
    public UpdateUserUseCasePort updateUserUseCasePort(
            UpdateUserAdapterPort updateUserAdapterPort,
            FindUserAdapterPort findUserAdapterPort,
            FindProfileAdapterPort findProfileAdapterPort,
            PasswordEncoderAdapterPort passwordEncoderAdapterPort
    ) {
        return new UpdateUserUseCase(updateUserAdapterPort, findUserAdapterPort, findProfileAdapterPort, passwordEncoderAdapterPort);
    }
    @Bean
    public FindPaginationUserUseCasePort findPaginationUserUseCasePort(FindPaginationUserAdapterPort findPaginationUserAdapterPort) {
        return new FindPaginationUserUseCase(findPaginationUserAdapterPort);
    }
}
