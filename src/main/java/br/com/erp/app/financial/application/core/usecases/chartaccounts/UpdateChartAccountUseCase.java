package br.com.erp.app.financial.application.core.usecases.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.in.chartaccounts.UpdateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.FindChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.UpdateChartAccountAdapterPort;

public class UpdateChartAccountUseCase implements UpdateChartAccountUseCasePort {

    private final UpdateChartAccountAdapterPort updateChartAccountAdapterPort;

    private final FindChartAccountAdapterPort findChartAccountAdapterPort;

    public UpdateChartAccountUseCase(UpdateChartAccountAdapterPort updateChartAccountAdapterPort, FindChartAccountAdapterPort findChartAccountAdapterPort) {
        this.updateChartAccountAdapterPort = updateChartAccountAdapterPort;
        this.findChartAccountAdapterPort = findChartAccountAdapterPort;
    }

    @Override
    public void update(ChartAccount chartAccount, Integer id) {
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
