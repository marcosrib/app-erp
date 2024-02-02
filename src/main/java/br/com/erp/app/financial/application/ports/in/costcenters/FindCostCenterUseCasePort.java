package br.com.erp.app.financial.application.ports.in.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

public interface FindCostCenterUseCasePort {
    PageableFinancialDomain<CostCenter> getCostCentersWithPaginationAndFilter(CostCenter costCenter, PageableFinancialRequestDomain pageable);
}
