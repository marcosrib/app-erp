package br.com.somar.app.common.config.beans;

import br.com.somar.app.users.application.core.usecases.abilitygroups.CreateAbilityGroupUseCase;
import br.com.somar.app.users.application.ports.in.abilitygroups.CreateAbilityGroupUseCasePort;
import br.com.somar.app.users.application.ports.out.abilitygroups.CreateAbilityGroupAdapterPort;
import br.com.somar.app.users.application.ports.out.abilitygroups.FindAbilityGroupAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AbilityGroupBeanConfig {
    @Bean
    public CreateAbilityGroupUseCasePort createAbilityGroupUseCasePort(FindAbilityGroupAdapterPort findAbilityGroupAdapterPort, CreateAbilityGroupAdapterPort createAbilityGroupAdapterPort) {
        return new CreateAbilityGroupUseCase(findAbilityGroupAdapterPort, createAbilityGroupAdapterPort);
    }
}
