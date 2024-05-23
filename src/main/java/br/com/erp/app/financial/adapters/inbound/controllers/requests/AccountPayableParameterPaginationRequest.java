package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.common.annotationcustom.IsEnum;
import br.com.erp.app.common.annotationcustom.ValidDateRange;
import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;
import br.com.erp.app.financial.application.core.domain.filters.AccountPayableFilter;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@ValidDateRange(startDateField = "dateDueInitial", endDateField = "dateDueFinal")
public record AccountPayableParameterPaginationRequest(
        @Parameter(name = "status", description = "Status: [PAID, PENDING, ALL]")
        @IsEnum(message = "O status é inválido, status correto: [PAID, PENDING, ALL]", enumClass = AccountPayableStatusEnum.class)
        String status,
        @Parameter(name = "costCenterId")
        @Min(value = 1, message = "O costCenterId {min.characters}" )
        Integer costCenterId,
        @Parameter(name = "dateDueInitial", description = "format: yyyy-mm-aa")
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "${date.format}")
        String dateDueInitial,
        @Parameter(name = "dateDueFinal", description = "format: yyyy-mm-aa")
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "${date.format}")
        String dateDueFinal
) {

        public AccountPayableFilter toAccountPayableFilterDomain() {
                return new AccountPayableFilter(
                        AccountPayableStatusEnum.from(status),
                        costCenterId,
                        LocalDate.parse(dateDueInitial),
                        LocalDate.parse(dateDueFinal));
        }
}
