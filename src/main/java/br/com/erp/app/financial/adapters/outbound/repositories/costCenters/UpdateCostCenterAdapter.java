package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.out.costcenters.UpdateCostCenterAdapterPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCostCenterAdapter implements UpdateCostCenterAdapterPort {

    private final CostCenterRepository costCenterRepository;

    public UpdateCostCenterAdapter(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }
    @Transactional
    @Override
    public void update(CostCenter costCenter) {
        costCenterRepository.save(CostCenterEntityMapper.convertCostCenterToCostCenterEntity(costCenter));
    }
}
