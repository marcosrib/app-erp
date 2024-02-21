package br.com.erp.app.financial.application.core.usecases.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.in.chartaccounts.CreateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.CreateChartAccountAdapterPort;

public class CreateChartAccountUseCase implements CreateChartAccountUseCasePort {

    private final CreateChartAccountAdapterPort createChartAccountAdapterPort;

    public CreateChartAccountUseCase(CreateChartAccountAdapterPort createChartAccountAdapterPort) {
        this.createChartAccountAdapterPort = createChartAccountAdapterPort;
    }

    @Override
    public void create(ChartAccount chartAccount) {
        createChartAccountAdapterPort.create(chartAccount);
    }
}
