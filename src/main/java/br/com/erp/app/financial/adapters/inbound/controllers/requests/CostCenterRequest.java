package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.financial.application.core.domain.CostCenter;

public record CostCenterRequest(String name) {

    public CostCenter toCostCenterDomain() {
        return CostCenter
                .builder()
                .name(name)
                .build();
    }
}
