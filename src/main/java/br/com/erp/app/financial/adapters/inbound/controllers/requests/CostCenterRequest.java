package br.com.erp.app.financial.adapters.inbound.controllers.requests;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import jakarta.validation.constraints.NotBlank;

public record CostCenterRequest(
        @NotBlank(message = "nome {name.not.empty}")
        String name
) {

    public CostCenter toCostCenterDomain() {
        return new CostCenter(name);
    }
}
