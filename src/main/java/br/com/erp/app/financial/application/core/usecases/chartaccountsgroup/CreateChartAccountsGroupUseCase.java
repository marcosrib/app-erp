package br.com.erp.app.financial.application.core.usecases.chartaccountsgroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.CreateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.CreateChartAccountsGroupAdapterPort;

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
