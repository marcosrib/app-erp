package br.com.erp.app.financial.config.beans;

import br.com.erp.app.financial.application.core.usecases.accountspayable.CreateAccountPayableUseCase;
import br.com.erp.app.financial.application.core.usecases.accountspayable.FindAccountPayableUseCase;
import br.com.erp.app.financial.application.core.usecases.accountspayable.UpdateAccountPayableUseCase;
import br.com.erp.app.financial.application.ports.in.accountspayable.CreateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.in.accountspayable.FindAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.in.accountspayable.UpdateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.out.accountspayable.CreateAccountPayableAdapterPort;
import br.com.erp.app.financial.application.ports.out.accountspayable.FindAccountPayableAdapterPort;
import br.com.erp.app.financial.application.ports.out.accountspayable.UpdateAccountPayableAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountPayableConfig {
    @Bean
    public CreateAccountPayableUseCasePort createAccountPayableUseCasePort(
            CreateAccountPayableAdapterPort createAccountPayableAdapterPort
    ) {
        return new CreateAccountPayableUseCase(createAccountPayableAdapterPort);
    }

    @Bean
    public UpdateAccountPayableUseCasePort updateAccountPayableUseCasePort(
            UpdateAccountPayableAdapterPort updateAccountPayableAdapterPort,
            FindAccountPayableAdapterPort findAccountPayableAdapterPort
    ) {
        return new UpdateAccountPayableUseCase(updateAccountPayableAdapterPort, findAccountPayableAdapterPort);
    }

    @Bean
    public FindAccountPayableUseCasePort findAccountPayableUseCasePort(
            FindAccountPayableAdapterPort findAccountPayableAdapterPort
    ) {
        return new FindAccountPayableUseCase(findAccountPayableAdapterPort);
    }

}

