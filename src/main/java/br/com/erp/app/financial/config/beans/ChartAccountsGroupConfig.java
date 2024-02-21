package br.com.erp.app.financial.config.beans;

import br.com.erp.app.financial.application.core.usecases.chartaccountsgroup.CreateChartAccountsGroupUseCase;
import br.com.erp.app.financial.application.core.usecases.chartaccountsgroup.FindChartAccountsGroupUseCase;
import br.com.erp.app.financial.application.core.usecases.chartaccountsgroup.UpdateChartAccountsGroupUseCase;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.CreateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.FindChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.UpdateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.CreateChartAccountsGroupAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.FindChartAccountsGroupAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.UpdateChartAccountsGroupAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChartAccountsGroupConfig {

    @Bean
    public CreateChartAccountsGroupUseCasePort createChartAccountsGroupUseCasePort(CreateChartAccountsGroupAdapterPort createChartAccountsGroupAdapterPort) {
        return new CreateChartAccountsGroupUseCase(createChartAccountsGroupAdapterPort);
    }
    @Bean
    public UpdateChartAccountsGroupUseCasePort updateChartAccountsGroupUseCasePort(UpdateChartAccountsGroupAdapterPort updateChartAccountsGroupAdapterPort,
                                                                                   FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort) {
        return new UpdateChartAccountsGroupUseCase(updateChartAccountsGroupAdapterPort, findChartAccountsGroupAdapterPort);
    }
    @Bean
    public FindChartAccountsGroupUseCasePort findChartAccountsGroupUseCasePort(FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort) {
        return new FindChartAccountsGroupUseCase(findChartAccountsGroupAdapterPort);
    }
}
