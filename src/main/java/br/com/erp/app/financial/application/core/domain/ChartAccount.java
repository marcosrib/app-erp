package br.com.erp.app.financial.application.core.domain;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountEntity;
import br.com.erp.app.financial.application.core.domain.enums.CharAccountTypeEnum;

import java.time.LocalDateTime;

public record ChartAccount(
        Integer id,
        String name,
        CharAccountTypeEnum type,
        ChartAccountsGroup chartAccountsGroup,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public ChartAccount(String name, CharAccountTypeEnum type, ChartAccountsGroup chartAccountsGroup) {
        this(null,name,type, chartAccountsGroup,null, null);
    }

    public static ChartAccount convertChartAccountEntityToChartAccount(ChartAccountEntity chartAccountEntity) {
        return new ChartAccount(
                chartAccountEntity.getId(),
                chartAccountEntity.getName(),
                chartAccountEntity.getType(),
                ChartAccountsGroup
                        .convertChartAccountsGroupEntityToChartAccountsGroup(chartAccountEntity.getChartAccountsGroupEntity()),
                chartAccountEntity.getCreatedAt(),
                chartAccountEntity.getUpdatedAt()
        );
    }
}
