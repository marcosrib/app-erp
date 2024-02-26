package br.com.erp.app.financial.application.core.domain;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record CostCenter(
        Integer id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public CostCenter(String name) {
        this(null,name,null, null);
    }

    public CostCenter(Integer id) {
        this(id,null,null, null);
    }

    public static CostCenter convertCostCenterEntityToCostCenter(CostCenterEntity costCenterEntity) {
        return new CostCenter(
                costCenterEntity.getId(),
                costCenterEntity.getName(),
                costCenterEntity.getCreatedAt(),
                costCenterEntity.getUpdatedAt()
        );
    }

    public static List<CostCenter> convertPageCostCenterEntityToListCostCenter(List<CostCenterEntity> costCenterEntities) {
        return costCenterEntities
                .stream().map(CostCenter::convertCostCenterEntityToCostCenter)
                .collect(Collectors.toList());
    }

}
