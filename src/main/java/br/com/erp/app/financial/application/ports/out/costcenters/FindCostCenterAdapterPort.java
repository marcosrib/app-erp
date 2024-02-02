package br.com.erp.app.financial.application.ports.out.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

public interface FindCostCenterAdapterPort {
    PageableFinancialDomain<CostCenter> findAllPagination(CostCenter filter, PageableFinancialRequestDomain pageable);
    CostCenter findById(Integer id);
}
