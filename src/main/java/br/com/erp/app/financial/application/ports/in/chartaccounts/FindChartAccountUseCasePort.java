package br.com.erp.app.financial.application.ports.in.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

public interface FindChartAccountUseCasePort {
    PageableFinancialDomain<ChartAccount> getChartAccountWithPaginationAndFilter(String name, PageableFinancialRequestDomain pageable);

}
