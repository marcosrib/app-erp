package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.core.usecases.abilitycategories.CreateAbilityCategoryUseCase;
import br.com.somar.app.users.application.ports.in.abilitycategories.CreateAbilityCategoryUseCasePort;
import br.com.somar.app.users.application.ports.out.abilitycategories.CreateAbilityCategoryAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitycategories.FindAbilityCategoryAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbilityCategoryBeanConfig {
    @Bean
    public CreateAbilityCategoryUseCasePort createAbilityCategoryUseCasePort(FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort, CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort) {
        return new CreateAbilityCategoryUseCase(findAbilityCategoryAdapterPort, createAbilityCategoryAdapterPort);
    }
}
