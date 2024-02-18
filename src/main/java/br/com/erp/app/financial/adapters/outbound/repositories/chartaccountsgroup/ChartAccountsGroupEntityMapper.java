package br.com.erp.app.financial.adapters.outbound.repositories.chartaccountsgroup;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountsGroupEntity;
import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

public class ChartAccountsGroupEntityMapper {
    public static ChartAccountsGroupEntity convertChartAccountsGroupToChartAccountsGroupEntity(ChartAccountsGroup chartAccountsGroup) {
        return  ChartAccountsGroupEntity
                .builder()
                .id(chartAccountsGroup.getId())
                .name(chartAccountsGroup.getName())
                .build();
    }
}
