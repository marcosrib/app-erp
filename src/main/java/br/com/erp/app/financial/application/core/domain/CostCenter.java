package br.com.erp.app.financial.application.core.domain;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import br.com.erp.app.financial.application.core.domain.builders.CostCenterBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CostCenter {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static CostCenter convertCostCenterEntityToCostCenter(CostCenterEntity costCenterEntity) {
     return CostCenter
             .builder()
             .id(costCenterEntity.getId())
             .name(costCenterEntity.getName())
             .createdAt(costCenterEntity.getCreatedAt())
             .updatedAt(costCenterEntity.getUpdatedAt())
             .build();
    }

    public static List<CostCenter> convertPageCostCenterEntityToListCostCenter(List<CostCenterEntity> costCenterEntities) {
        return costCenterEntities
                .stream().map(CostCenter::convertCostCenterEntityToCostCenter)
                .collect(Collectors.toList());
    }

    public static CostCenterBuilder builder() {
        return new CostCenterBuilder();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
