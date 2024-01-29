package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import br.com.erp.app.financial.application.core.domain.CostCenter;

public class CostCenterEntityMapper {

    public static CostCenterEntity convertCostCenterToCostCenterEntity(CostCenter costCenter) {
        return  CostCenterEntity
                .builder()
                .name(costCenter.getName())
                .build();
    }
}
