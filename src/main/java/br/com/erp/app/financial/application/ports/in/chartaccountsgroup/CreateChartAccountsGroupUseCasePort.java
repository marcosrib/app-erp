package br.com.erp.app.financial.application.ports.in.chartaccountsgroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

public interface CreateChartAccountsGroupUseCasePort {
    void create(ChartAccountsGroup chartAccountsGroup);
}
