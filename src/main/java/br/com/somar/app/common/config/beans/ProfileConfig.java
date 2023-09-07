package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.CreateProfileAdapterPort;
import br.com.somar.app.users.application.core.usecases.profiles.CreateProfileUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ProfileConfig {
    @Bean
    public CreateProfileUseCasePort createProfileUseCasePort(
            CreateProfileAdapterPort createProfileAdapterPort) {
        return new CreateProfileUseCase(createProfileAdapterPort);
    }
}