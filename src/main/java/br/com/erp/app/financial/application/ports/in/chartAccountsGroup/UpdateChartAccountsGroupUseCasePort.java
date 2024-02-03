package br.com.erp.app.financial.application.ports.in.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

public interface UpdateChartAccountsGroupUseCasePort {
    void update(ChartAccountsGroup chartAccountsGroup, Integer id);
}
