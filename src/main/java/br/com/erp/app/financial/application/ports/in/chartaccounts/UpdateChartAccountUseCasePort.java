package br.com.erp.app.financial.application.ports.in.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;

public interface UpdateChartAccountUseCasePort {
    void update(ChartAccount chartAccount, Integer id);
}
