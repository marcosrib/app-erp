package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.AccountPayableEntity;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountEntity;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import br.com.erp.app.financial.application.core.domain.AccountPayable;

public class AccountPayableEntityMapper {

    public static AccountPayableEntity convertAccountPayableToAccountPayableEntity(AccountPayable accountPayable) {

        return  AccountPayableEntity
                .builder()
                .id(accountPayable.id())
                .chartAccountEntity(ChartAccountEntity.builder().id(accountPayable.chartAccount().id()).build())
                .value(accountPayable.value())
                .costCenterEntity(CostCenterEntity.builder().id(accountPayable.costCenter().id()).build())
                .paymentDate(accountPayable.paymentDate())
                .status(accountPayable.status())
                .dueDate(accountPayable.dueDate())
                .createdAt(accountPayable.createdAt())
                .build();
    }
}
