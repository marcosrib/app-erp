package br.com.erp.app.financial.application.ports.out.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

import java.util.List;

public interface FindChartAccountsGroupAdapterPort {
    ChartAccountsGroup findById(Integer id);
    List<ChartAccountsGroup> findAll();
    PageableFinancialDomain<ChartAccountsGroup> findAllPagination(String name, PageableFinancialRequestDomain pageable);
}
