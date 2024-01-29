package br.com.erp.app.financial.application.core.usecases.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.in.costcenters.CreateCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.out.costcenters.CreateCostCenterAdapterPort;

public class CreateCostCenterUseCase implements CreateCostCenterUseCasePort {

    private final CreateCostCenterAdapterPort createCostCenterUseCasePort;

    public CreateCostCenterUseCase(CreateCostCenterAdapterPort createCostCenterUseCasePort) {
        this.createCostCenterUseCasePort = createCostCenterUseCasePort;
    }

    @Override
    public void create(CostCenter costCenter) {
     createCostCenterUseCasePort.create(costCenter);
    }
}
