package br.com.erp.app.financial.application.ports.out.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;

public interface UpdateCostCenterAdapterPort {
    void update(CostCenter costCenter);
}
