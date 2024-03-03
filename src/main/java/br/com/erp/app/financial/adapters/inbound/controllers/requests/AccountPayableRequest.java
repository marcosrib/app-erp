package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record AccountPayableRequest(
        BigDecimal value,
        String status,
        Integer chartAccountId,
        Integer costCenterId,
        LocalDateTime paymentDate,
        LocalDate dueDate
) {
    public AccountPayable toAccountPayableDomain() {
        return AccountPayable
                .builder()
                .value(value)
                .status(AccountPayableStatusEnum.valueOf(status))
                .chartAccount(new ChartAccount(chartAccountId))
                .costCenter(new CostCenter(costCenterId))
                .paymentDate(paymentDate)
                .dueDate(dueDate)
                .build();
    }
}
