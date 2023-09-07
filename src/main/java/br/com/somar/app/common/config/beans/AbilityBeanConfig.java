package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.ports.in.abilities.FindAbilityUseCasePort;
import br.com.somar.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.core.usecases.abilities.FindAbilityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbilityBeanConfig {
    @Bean
    public FindAbilityUseCasePort findAbilityUseCasePort(FindProfileAdapterPort findProfileAdapterPort, FindAbilityAdapterPort findAbilityAdapterPort) {
        return new FindAbilityUseCase(findProfileAdapterPort, findAbilityAdapterPort);
    }
}
