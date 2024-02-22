package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.common.annotationcustom.IsEnum;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.core.domain.enums.CharAccountTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ChartAccountRequest(
        @NotBlank(message = "O nome {name.not.empty}")
        @Size(min = 5, message = "O nome {min.characters}")
        String name,
        @IsEnum(message = "O tipe é inválido, tipe correto: [EXPENSES, REVENUE]", enumClass = CharAccountTypeEnum.class)
        @NotNull(message = "O tipo {name.not.empty}")
        String type,

        @NotNull(message = "O Id grupo plano de contas {name.not.empty}")
        Integer chartAccountsGroupId
) {

    public ChartAccount toChartAccountDomain() {
        return new ChartAccount(
                name,
                CharAccountTypeEnum.valueOf(type),
                ChartAccountsGroup.
                    builder().
                    id(chartAccountsGroupId)
                .build());
    }
}
