package br.com.erp.app.financial.application.core.domain.builders;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

import java.time.LocalDateTime;

public class ChartAccountsGroupBuilder {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChartAccountsGroupBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public ChartAccountsGroupBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ChartAccountsGroupBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ChartAccountsGroupBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
    public ChartAccountsGroup build() {
        ChartAccountsGroup chartAccountsGroup = new ChartAccountsGroup();
        chartAccountsGroup.setId(id);
        chartAccountsGroup.setName(name);
        chartAccountsGroup.setCreatedAt(createdAt);
        chartAccountsGroup.setUpdatedAt(updatedAt);
        return chartAccountsGroup;
    }
}
