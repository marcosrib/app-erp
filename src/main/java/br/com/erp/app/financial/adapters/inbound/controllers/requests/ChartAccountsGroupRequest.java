package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

public record ChartAccountsGroupRequest(String name) {
    public ChartAccountsGroup toChartAccountsGroupDomain() {
        return ChartAccountsGroup
                .builder()
                .name(name)
                .build();
    }
}
