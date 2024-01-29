package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.out.costcenters.CreateCostCenterAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCreateCostCenterAdapter implements CreateCostCenterAdapterPort {

    private final CostCenterRepository costCenterRepository;

    public CreateCreateCostCenterAdapter(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    @Override
    public void create(CostCenter costCenter) {
        costCenterRepository.save(CostCenterEntityMapper.convertCostCenterToCostCenterEntity(costCenter));
    }
}
