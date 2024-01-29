package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.out.costcenters.FindCostCenterAdapterPort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindCostCenterAdapter implements FindCostCenterAdapterPort {
    private final CostCenterRepository costCenterRepository;

    public FindCostCenterAdapter(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    @Override
    public List<CostCenter> findAll() {
        return null;
    }

    @Override
    public CostCenter findById(Integer id) {
       var costCenter =  costCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cost.center.not.found"));
        return CostCenter.convertCostCenterEntityToCostCenter(costCenter);
    }
}
