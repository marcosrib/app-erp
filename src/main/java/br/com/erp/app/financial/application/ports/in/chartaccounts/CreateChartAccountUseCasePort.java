package br.com.erp.app.financial.application.ports.in.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;

public interface CreateChartAccountUseCasePort {
    void create(ChartAccount chartAccount);
}
