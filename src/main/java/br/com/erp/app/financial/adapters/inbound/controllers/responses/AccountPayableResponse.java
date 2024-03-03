package br.com.erp.app.financial.adapters.inbound.controllers.responses;

import br.com.erp.app.financial.application.core.domain.AccountPayable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record AccountPayableResponse(
        Long id,
        BigDecimal value,
        AccountPayableStatusEnumResponse status,
        ChartAccountResponseForAccountPayableResponse chartAccount,
        CostCenterResponse costCenter,
        LocalDateTime paymentDate,
        LocalDate dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

    public static AccountPayableResponse fromDomain(AccountPayable accountPayable) {
        return new AccountPayableResponse(
                accountPayable.id(),
                accountPayable.value(),
                new AccountPayableStatusEnumResponse(accountPayable.status().name(), accountPayable.status().getDescription()),
                new ChartAccountResponseForAccountPayableResponse(
                        accountPayable.chartAccount().id(),
                        accountPayable.chartAccount().name()),
                new CostCenterResponse(
                        accountPayable.costCenter().id(),
                        accountPayable.costCenter().name()),
                accountPayable.paymentDate(),
                accountPayable.dueDate(),
                accountPayable.createdAt(),
                accountPayable.updatedAt()
        );
    }

    public static List<AccountPayableResponse> fromDomainToList(List<AccountPayable> accountsPayable) {
        return accountsPayable.stream().map(AccountPayableResponse::fromDomain).toList();
    }
}
