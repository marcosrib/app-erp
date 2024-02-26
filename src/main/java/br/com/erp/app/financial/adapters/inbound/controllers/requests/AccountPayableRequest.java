package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.CostCenter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountPayableRequest(
        BigDecimal value,
        String status,
        Integer chartAccountId,
        Integer costCenterId,
        LocalDateTime paymentDate,
        LocalDateTime dueDate
) {
    public AccountPayable toAccountPayableDomain() {
        return AccountPayable
                .builder()
                .value(value)
                .status(status)
                .chartAccount(new ChartAccount(chartAccountId))
                .costCenter(new CostCenter(costCenterId))
                .paymentDate(paymentDate)
                .dueDate(dueDate)
                .build();
    }
}
