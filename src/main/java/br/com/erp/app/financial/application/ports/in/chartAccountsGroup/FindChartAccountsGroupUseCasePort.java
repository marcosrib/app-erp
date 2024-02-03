package br.com.erp.app.financial.application.ports.in.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

import java.util.List;

public interface FindChartAccountsGroupUseCasePort {
    List<ChartAccountsGroup> findAllChartAccountsGroup();
}
