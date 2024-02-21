package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.core.domain.enums.CharAccountTypeEnum;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Plano de contas API")
public record ChartAccountRequest(
        String name,
        CharAccountTypeEnum type,
        Integer chartAccountsGroupId
) {

    public ChartAccount toChartAccountDomain() {
        return new ChartAccount(
                name,
                type,
                ChartAccountsGroup.
                    builder().
                    id(chartAccountsGroupId)
                .build());
    }
}
