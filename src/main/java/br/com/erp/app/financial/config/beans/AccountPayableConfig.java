package br.com.erp.app.financial.config.beans;

import br.com.erp.app.financial.adapters.outbound.repositories.accountspayable.CreateAccountPayableAdapter;
import br.com.erp.app.financial.application.core.usecases.accountspayable.CreateAccountPayableUseCase;
import br.com.erp.app.financial.application.core.usecases.chartaccounts.CreateChartAccountUseCase;
import br.com.erp.app.financial.application.ports.in.accountspayable.CreateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccounts.CreateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.accountspayable.CreateAccountPayableAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.CreateChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.FindChartAccountsGroupAdapterPort;
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
}
