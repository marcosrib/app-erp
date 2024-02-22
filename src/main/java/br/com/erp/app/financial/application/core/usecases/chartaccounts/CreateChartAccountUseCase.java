package br.com.erp.app.financial.application.core.usecases.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.in.chartaccounts.CreateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.CreateChartAccountAdapterPort;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.FindChartAccountsGroupAdapterPort;

public class CreateChartAccountUseCase implements CreateChartAccountUseCasePort {

    private final CreateChartAccountAdapterPort createChartAccountAdapterPort;
    private final FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort;

    public CreateChartAccountUseCase(
            CreateChartAccountAdapterPort createChartAccountAdapterPort,
            FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort
    ) {
        this.createChartAccountAdapterPort = createChartAccountAdapterPort;
        this.findChartAccountsGroupAdapterPort = findChartAccountsGroupAdapterPort;
    }

    @Override
    public void create(ChartAccount chartAccount) {
        findChartAccountsGroupAdapterPort.findById(chartAccount.chartAccountsGroup().getId());
        createChartAccountAdapterPort.create(chartAccount);
    }
}
