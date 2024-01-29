package br.com.erp.app.financial.application.core.domain.builders;

import br.com.erp.app.financial.application.core.domain.CostCenter;

import java.time.LocalDateTime;

public class CostCenterBuilder {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CostCenterBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public CostCenterBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CostCenterBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CostCenterBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public CostCenter build() {
     CostCenter costCenter = new CostCenter();
     costCenter.setId(id);
     costCenter.setName(name);
     costCenter.setCreatedAt(createdAt);
     costCenter.setUpdatedAt(updatedAt);
     return costCenter;
    }
}
