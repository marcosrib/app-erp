package br.com.erp.app.financial.application.ports.out.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

import java.util.List;

public interface FindCostCenterAdapterPort {
    PageableFinancialDomain<CostCenter> findAllPagination(String name, PageableFinancialRequestDomain pageable);

    CostCenter findById(Integer id);
    List<CostCenter> findAllCostCenter();
}