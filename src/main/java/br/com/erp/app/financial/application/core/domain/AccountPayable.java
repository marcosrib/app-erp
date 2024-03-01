package br.com.erp.app.financial.application.core.domain;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.AccountPayableEntity;
import br.com.erp.app.financial.application.core.domain.builders.AccountPayableBuilder;
import br.com.erp.app.registers.application.core.domain.Supplier;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record AccountPayable(
        Long id,
        BigDecimal value,
        String status,
        ChartAccount chartAccount,
        Supplier supplier,
        CostCenter costCenter,
        LocalDateTime paymentDate,
        LocalDateTime dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
    public static AccountPayableBuilder builder() {
        return new AccountPayableBuilder();
    }

    public static AccountPayable convertAccountPayableEntityToAccountPayable(AccountPayableEntity accountPayableEntity) {

        return new AccountPayable(
                accountPayableEntity.getId(),
                accountPayableEntity.getValue(),
                accountPayableEntity.getStatus(),
                ChartAccount.convertChartAccountEntityToChartAccount(accountPayableEntity.getChartAccountEntity()),
                Supplier.builder()
                        .id(accountPayableEntity.getSupplierEntity() != null ? accountPayableEntity.getSupplierEntity().getId() : null )
                        .fantasyName(accountPayableEntity.getSupplierEntity() != null ? accountPayableEntity.getSupplierEntity().getFantasyName() : null)
                        .build(),
                CostCenter.convertCostCenterEntityToCostCenter(accountPayableEntity.getCostCenterEntity()),
                accountPayableEntity.getPaymentDate(),
                accountPayableEntity.getDueDate(),
                accountPayableEntity.getCreatedAt(),
                accountPayableEntity.getUpdatedAt()
        );
    }

    public static List<AccountPayable> convertAccountPayableEntityListToAccountPayableList(List<AccountPayableEntity> accountPayableEntities) {
        return accountPayableEntities
                .stream()
                .map(AccountPayable::convertAccountPayableEntityToAccountPayable)
                .toList();
    }
}
