package br.com.erp.app.financial.application.ports.out.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;

import java.util.List;

public interface FindCostCenterAdapterPort {
    List<CostCenter> findAll();
    CostCenter findById(Integer id);
}
