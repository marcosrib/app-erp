package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.common.annotationcustom.IsEnum;
import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record AccountPayableRequest(
        @DecimalMin(value = "0", inclusive = false)
        @Digits(integer=10, fraction=2)
        BigDecimal value,
        @NotBlank(message = "O status ${not.empty}")
        @NotNull(message = "O status ${not.empty}")
        @IsEnum(message = "O status é inválido, status correto: [PAID, PENDING]", excludeValue = "ALL", enumClass = AccountPayableStatusEnum.class)
        String status,
        @Min(value = 1, message = "O chartAccountId {min.characters}" )
        Integer chartAccountId,
        @Min(value = 1, message = "O costCenterId {min.characters}" )
        Integer costCenterId,
        LocalDateTime paymentDate,
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "${date.format}")
        String dueDate
) {
    public AccountPayable toAccountPayableDomain() {
        return AccountPayable
                .builder()
                .value(value)
                .status(AccountPayableStatusEnum.valueOf(status))
                .chartAccount(new ChartAccount(chartAccountId))
                .costCenter(new CostCenter(costCenterId))
                .paymentDate(paymentDate)
                .dueDate(LocalDate.parse(dueDate))
                .build();
    }
}
