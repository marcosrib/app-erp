package br.com.erp.app.financial.application.ports.in.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

public interface CreateChartAccountsGroupUseCasePort {
    void create(ChartAccountsGroup chartAccountsGroup);
}
