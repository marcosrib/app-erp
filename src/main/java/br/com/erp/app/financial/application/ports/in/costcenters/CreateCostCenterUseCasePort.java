package br.com.erp.app.financial.application.ports.in.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;

public interface CreateCostCenterUseCasePort {
    void create(CostCenter costCenter);
}
