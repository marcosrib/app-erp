package br.com.erp.app.financial.application.core.usecases.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.in.chartaccounts.UpdateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.FindChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.UpdateChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.FindChartAccountsGroupAdapterPort;

public class UpdateChartAccountUseCase implements UpdateChartAccountUseCasePort {

    private final UpdateChartAccountAdapterPort updateChartAccountAdapterPort;

    private final FindChartAccountAdapterPort findChartAccountAdapterPort;

    private final FindChartAccountsGroupAdapterPort chartAccountsGroupAdapterPort;
    public UpdateChartAccountUseCase(UpdateChartAccountAdapterPort updateChartAccountAdapterPort, FindChartAccountAdapterPort findChartAccountAdapterPort, FindChartAccountsGroupAdapterPort chartAccountsGroupAdapterPort) {
        this.updateChartAccountAdapterPort = updateChartAccountAdapterPort;
        this.findChartAccountAdapterPort = findChartAccountAdapterPort;
        this.chartAccountsGroupAdapterPort = chartAccountsGroupAdapterPort;
    }

    @Override
    public void update(ChartAccount chartAccount, Integer id) {
        chartAccountsGroupAdapterPort.findById(chartAccount.chartAccountsGroup().getId());
        var chartAccountActual = findChartAccountAdapterPort.findChartAccountById(id);
        var updatedChartAccount = new ChartAccount(
                chartAccountActual.id(),
                chartAccount.name(),
                chartAccount.type(),
                chartAccount.chartAccountsGroup(),
                chartAccountActual.createdAt(),
                chartAccountActual.updatedAt()
        );
        updateChartAccountAdapterPort.update(updatedChartAccount);
    }
}
