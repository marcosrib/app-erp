package br.com.erp.app.financial.application.core.domain;

import br.com.erp.app.financial.application.core.domain.builders.AccountPayableBuilder;
import br.com.erp.app.registers.application.core.domain.Supplier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountPayable(
        Long id,
        BigDecimal value,
        String status,
        ChartAccount chartAccount,
        Supplier Supplier,
        CostCenter costCenter,
        LocalDateTime paymentDate,
        LocalDateTime dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
    public static AccountPayableBuilder builder() {
        return new AccountPayableBuilder();
    }
}
