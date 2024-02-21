package br.com.erp.app.financial.application.ports.out.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;

public interface CreateChartAccountAdapterPort {
    void create(ChartAccount chartAccount);
}
