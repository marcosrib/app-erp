package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.core.usecases.profiles.FindAllProfileUseCase;
import br.com.somar.app.users.application.core.usecases.profiles.UpdateProfileUseCase;
import br.com.somar.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.somar.app.users.application.ports.in.profiles.UpdateProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.CreateProfileAdapterPort;
import br.com.somar.app.users.application.core.usecases.profiles.CreateProfileUseCase;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.ports.out.profiles.UpdateProfileAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ProfileConfig {
    @Bean
    public CreateProfileUseCasePort createProfileUseCasePort(
            CreateProfileAdapterPort createProfileAdapterPort) {
        return new CreateProfileUseCase(createProfileAdapterPort);
    }
    @Bean
    public UpdateProfileUseCasePort updateProfileUseCasePort(UpdateProfileAdapterPort updateProfileAdapterPort, FindProfileAdapterPort findProfileAdapterPort) {
        return new UpdateProfileUseCase(updateProfileAdapterPort, findProfileAdapterPort);
    }
    @Bean
    public FindAllProfileUseCase findAllProfileUseCase(
            FindProfileAdapterPort findProfileAdapterPort) {
        return new FindAllProfileUseCase(findProfileAdapterPort);
    }
}