package br.com.erp.app.financial.config.beans;

import br.com.erp.app.financial.application.core.usecases.chartaccounts.CreateChartAccountUseCase;
import br.com.erp.app.financial.application.core.usecases.chartaccounts.FindChartAccountUseCase;
import br.com.erp.app.financial.application.core.usecases.chartaccounts.UpdateChartAccountUseCase;
import br.com.erp.app.financial.application.ports.in.chartaccounts.CreateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccounts.FindChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccounts.UpdateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.CreateChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.FindChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.UpdateChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.FindChartAccountsGroupAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChartAccountsConfig {
    @Bean
    public CreateChartAccountUseCasePort createChartAccountUseCasePort(
            CreateChartAccountAdapterPort createChartAccountAdapterPort,
            FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort
    ) {
        return new CreateChartAccountUseCase(createChartAccountAdapterPort, findChartAccountsGroupAdapterPort);
    }

    @Bean
    public UpdateChartAccountUseCasePort updateChartAccountUseCasePort(
            UpdateChartAccountAdapterPort updateChartAccountAdapterPort,
            FindChartAccountAdapterPort findChartAccountAdapterPort,
            FindChartAccountsGroupAdapterPort chartAccountsGroupAdapterPort) {
        return new UpdateChartAccountUseCase(updateChartAccountAdapterPort, findChartAccountAdapterPort, chartAccountsGroupAdapterPort);
    }

    @Bean
    public FindChartAccountUseCasePort findChartAccountUseCasePort(
            FindChartAccountAdapterPort findChartAccountAdapterPort
    ) {
        return new FindChartAccountUseCase(findChartAccountAdapterPort);
    }
}
