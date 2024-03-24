package br.com.erp.app.financial.application.core.domain.filters;

import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;

import java.time.LocalDate;

public record AccountPayableFilter(
        AccountPayableStatusEnum status,
        Integer costCenterId,
        LocalDate dateDueInitial,
        LocalDate dateDueFinal) {
}
