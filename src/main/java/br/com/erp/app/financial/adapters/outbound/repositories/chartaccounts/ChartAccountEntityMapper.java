package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountEntity;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountsGroupEntity;
import br.com.erp.app.financial.application.core.domain.ChartAccount;

public class ChartAccountEntityMapper {
    public static ChartAccountEntity convertChartAccountToChartAccountEntity(ChartAccount chartAccount) {

        return  ChartAccountEntity
                .builder()
                .id(chartAccount.id())
                .name(chartAccount.name())
                .type(chartAccount.type())
                .chartAccountsGroupEntity(ChartAccountsGroupEntity.builder().id(chartAccount.chartAccountsGroup().getId()).build())
                .build();
    }
}
