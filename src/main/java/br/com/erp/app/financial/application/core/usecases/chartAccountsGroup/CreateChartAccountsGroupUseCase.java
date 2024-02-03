package br.com.erp.app.financial.application.core.usecases.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.CreateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.CreateChartAccountsGroupAdapterPort;

public class CreateChartAccountsGroupUseCase implements CreateChartAccountsGroupUseCasePort {

    private final CreateChartAccountsGroupAdapterPort createChartAccountsGroupAdapterPort;

    public CreateChartAccountsGroupUseCase(CreateChartAccountsGroupAdapterPort createChartAccountsGroupAdapterPort) {
        this.createChartAccountsGroupAdapterPort = createChartAccountsGroupAdapterPort;
    }

    @Override
    public void create(ChartAccountsGroup chartAccountsGroup) {
        createChartAccountsGroupAdapterPort.create(chartAccountsGroup);
    }
}
