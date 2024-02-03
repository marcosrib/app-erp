package br.com.erp.app.financial.config.beans;

import br.com.erp.app.financial.application.core.usecases.chartAccountsGroup.CreateChartAccountsGroupUseCase;
import br.com.erp.app.financial.application.core.usecases.chartAccountsGroup.FindChartAccountsGroupUseCase;
import br.com.erp.app.financial.application.core.usecases.chartAccountsGroup.UpdateChartAccountsGroupUseCase;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.CreateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.FindChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.UpdateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.CreateChartAccountsGroupAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.FindChartAccountsGroupAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.UpdateChartAccountsGroupAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class chartAccountsGroupConfig {

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
