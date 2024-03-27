package br.com.erp.app.financial.application.ports.out.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

import java.util.List;

public interface FindChartAccountAdapterPort {

    ChartAccount findChartAccountById(Integer id);

    PageableFinancialDomain<ChartAccount> findAllPagination(String name, PageableFinancialRequestDomain pageable);

    List<ChartAccount> findAllChartAccount();

}
