package br.com.erp.app.financial.application.ports.out.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

import java.util.List;

public interface FindChartAccountsGroupAdapterPort {
    ChartAccountsGroup findById(Integer id);
    List<ChartAccountsGroup> findAll();
}
