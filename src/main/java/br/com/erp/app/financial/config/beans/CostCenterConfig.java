package br.com.erp.app.financial.config.beans;

import br.com.erp.app.financial.adapters.outbound.repositories.costcenters.FindCostCenterAdapter;
import br.com.erp.app.financial.application.core.usecases.costcenters.CreateCostCenterUseCase;
import br.com.erp.app.financial.application.core.usecases.costcenters.FindCostCenterUseCase;
import br.com.erp.app.financial.application.core.usecases.costcenters.UpdateCostCenterUseCase;
import br.com.erp.app.financial.application.ports.in.costcenters.CreateCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.in.costcenters.FindCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.in.costcenters.UpdateCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.out.costcenters.CreateCostCenterAdapterPort;
import br.com.erp.app.financial.application.ports.out.costcenters.FindCostCenterAdapterPort;
import br.com.erp.app.financial.application.ports.out.costcenters.UpdateCostCenterAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CostCenterConfig {

    @Bean
    public CreateCostCenterUseCasePort createCostCenterUseCasePort(CreateCostCenterAdapterPort createCostCenterAdapterPort) {
        return new CreateCostCenterUseCase(createCostCenterAdapterPort);
    }

    @Bean
    public UpdateCostCenterUseCasePort updateCostCenterUseCasePort(UpdateCostCenterAdapterPort updateCostCenterAdapterPort, FindCostCenterAdapter findCostCenterAdapter) {
        return new UpdateCostCenterUseCase(updateCostCenterAdapterPort, findCostCenterAdapter);
    }

    @Bean
    public FindCostCenterUseCasePort findCostCenterUseCasePort(FindCostCenterAdapterPort findCostCenterAdapterPort) {
        return new FindCostCenterUseCase(findCostCenterAdapterPort);
    }
}
