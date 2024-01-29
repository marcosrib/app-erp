package br.com.erp.app.financial.application.core.usecases.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.in.costcenters.UpdateCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.out.costcenters.FindCostCenterAdapterPort;
import br.com.erp.app.financial.application.ports.out.costcenters.UpdateCostCenterAdapterPort;

public class UpdateCostCenterUseCase implements UpdateCostCenterUseCasePort {
    private final UpdateCostCenterAdapterPort costCenterAdapterPort;
    private final FindCostCenterAdapterPort findCostCenterAdapterPort;

    public UpdateCostCenterUseCase(UpdateCostCenterAdapterPort costCenterAdapterPort, FindCostCenterAdapterPort findCostCenterAdapterPort) {
        this.costCenterAdapterPort = costCenterAdapterPort;
        this.findCostCenterAdapterPort = findCostCenterAdapterPort;
    }

    @Override
    public void update(CostCenter costCenter, Integer id) {
        CostCenter costCenterResult = findCostCenterAdapterPort.findById(id);
        costCenterResult.setName(costCenter.getName());
        costCenterAdapterPort.update(costCenter);
    }
}
