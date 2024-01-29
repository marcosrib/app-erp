package br.com.erp.app.financial.application.ports.in.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;

public interface UpdateCostCenterUseCasePort {
    void update(CostCenter costCenter, Integer id);
}
