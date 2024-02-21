package br.com.erp.app.financial.application.ports.out.chartaccountsgroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

public interface CreateChartAccountsGroupAdapterPort {
    void create(ChartAccountsGroup chartAccountsGroup);
}
