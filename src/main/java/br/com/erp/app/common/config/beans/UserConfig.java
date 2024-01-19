package br.com.erp.app.common.config.beans;

import br.com.erp.app.users.application.core.usecases.users.*;
import br.com.erp.app.users.application.ports.in.users.*;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.erp.app.users.application.ports.out.users.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserUseCasePort createUserUseCasePort(
            CreateUserAdapterPort createUserAdapterPort,
            PasswordEncoderAdapterPort encoder,
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

    @Bean
    public UpdateUserStatusUseCasePort updateUserStatusUseCasePort(FindUserAdapterPort findUserAdapterPort, UpdateUserStatusAdapterPort updateUserStatusAdapterPort) {
        return new UpdateUserStatusUseCase(findUserAdapterPort, updateUserStatusAdapterPort);
    }

    @Bean
    public FindUserUseCasePort findUserUseCasePort(FindUserAdapterPort findUserAdapterPort) {
        return new FindUserUseCase(findUserAdapterPort);
    }
}
