package br.com.erp.app.common.config.beans;

import br.com.erp.app.users.adapters.outbound.fileproperties.GetAbilitiesIntoPropertiesFile;
import br.com.erp.app.users.application.core.usecases.abilities.CreateAbilityUseCase;
import br.com.erp.app.users.application.core.usecases.abilities.FindAbilityUseCase;
import br.com.erp.app.users.application.ports.in.abilities.CreateAbilityUseCasePort;
import br.com.erp.app.users.application.ports.in.abilities.FindAbilityUseCasePort;
import br.com.erp.app.users.application.ports.in.abilitycategories.CreateAbilityCategoryUseCasePort;
import br.com.erp.app.users.application.ports.in.abilitygroups.CreateAbilityGroupUseCasePort;
import br.com.erp.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;
import br.com.erp.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import br.com.erp.app.users.application.ports.out.abilitycategories.CreateAbilityCategoryAdapterPort;
import br.com.erp.app.users.application.ports.out.abilitycategories.FindAbilityCategoryAdapterPort;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbilityBeanConfig {
    @Bean
    public FindAbilityUseCasePort findAbilityUseCasePort(FindProfileAdapterPort findProfileAdapterPort, FindAbilityAdapterPort findAbilityAdapterPort) {
        return new FindAbilityUseCase(findProfileAdapterPort, findAbilityAdapterPort);
    }

    @Bean
    public CreateAbilityUseCasePort createAbilityUseCasePort(
            CreateAbilityAdapterPort createAbilityAdapterPort,
            GetAbilitiesIntoPropertiesFile getAbilitiesIntoPropertiesFile,
            FindAbilityCategoryAdapterPort findAbilityCategoryAdapterPort,
            CreateAbilityCategoryAdapterPort createAbilityCategoryAdapterPort,
            FindAbilityAdapterPort findAbilityAdapterPort,
            CreateAbilityGroupUseCasePort createAbilityGroupUseCasePort,
            CreateAbilityCategoryUseCasePort createAbilityCategoryUseCasePort
    ) {
        return new CreateAbilityUseCase(
                createAbilityAdapterPort,
                getAbilitiesIntoPropertiesFile,
                findAbilityAdapterPort,
                createAbilityGroupUseCasePort,
                createAbilityCategoryUseCasePort
        );
    }
}
