package br.com.erp.app.financial.application.core.usecases.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.UpdateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.FindChartAccountsGroupAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.UpdateChartAccountsGroupAdapterPort;

public class UpdateChartAccountsGroupUseCase implements UpdateChartAccountsGroupUseCasePort {

    private final UpdateChartAccountsGroupAdapterPort updateChartAccountsGroupAdapterPort;
    private final FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort;

    public UpdateChartAccountsGroupUseCase(UpdateChartAccountsGroupAdapterPort updateChartAccountsGroupAdapterPort, FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort) {
        this.updateChartAccountsGroupAdapterPort = updateChartAccountsGroupAdapterPort;
        this.findChartAccountsGroupAdapterPort = findChartAccountsGroupAdapterPort;
    }

    @Override
    public void update(ChartAccountsGroup chartAccountsGroup, Integer id) {
        var chartAccountsGroupExisting = findChartAccountsGroupAdapterPort.findById(id);
        chartAccountsGroupExisting.setName(chartAccountsGroup.getName());
        updateChartAccountsGroupAdapterPort.update(chartAccountsGroupExisting);
    }
}
