package br.com.erp.app.financial.application.core.usecases.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.costcenters.FindCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.out.costcenters.FindCostCenterAdapterPort;

public class FindCostCenterUseCase implements FindCostCenterUseCasePort {

    private final FindCostCenterAdapterPort findCostCenterAdapterPort;

    public FindCostCenterUseCase(FindCostCenterAdapterPort findCostCenterAdapterPort) {
        this.findCostCenterAdapterPort = findCostCenterAdapterPort;
    }
    @Override
    public PageableFinancialDomain<CostCenter> getCostCentersWithPaginationAndFilter(CostCenter costCenter, PageableFinancialRequestDomain pageable) {
        return findCostCenterAdapterPort.findAllPagination(costCenter, pageable);
    }
}
