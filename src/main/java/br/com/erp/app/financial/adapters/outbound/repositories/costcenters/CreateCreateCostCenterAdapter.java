package br.com.erp.app.financial.adapters.outbound.repositories.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.out.costcenters.CreateCostCenterAdapterPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCreateCostCenterAdapter implements CreateCostCenterAdapterPort {

    private final CostCenterRepository costCenterRepository;

    public CreateCreateCostCenterAdapter(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    @Transactional
    @Override
    public void create(CostCenter costCenter) {
        costCenterRepository.save(CostCenterEntityMapper.convertCostCenterToCostCenterEntity(costCenter));
    }
}
