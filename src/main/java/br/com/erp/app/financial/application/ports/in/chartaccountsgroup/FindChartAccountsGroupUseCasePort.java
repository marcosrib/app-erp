package br.com.erp.app.financial.application.ports.in.chartaccountsgroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

import java.util.List;

public interface FindChartAccountsGroupUseCasePort {
    List<ChartAccountsGroup> findAllChartAccountsGroup();
    PageableFinancialDomain<ChartAccountsGroup> getChartAccountsGroupWithPaginationAndFilter(String name, PageableFinancialRequestDomain pageable);
}
