package br.com.erp.app.financial.adapters.inbound.controllers.responses;

import br.com.erp.app.financial.application.core.domain.CostCenter;

import java.util.List;
import java.util.stream.Collectors;

public record CostCenterResponse(Integer id, String name) {

    public static CostCenterResponse fromDomain(CostCenter costCenter) {
       return new CostCenterResponse(
               costCenter.getId(),
               costCenter.getName()
       );
    }

    public static List<CostCenterResponse> fromDomainToList(List<CostCenter> costCenters) {
        return  costCenters.stream().map(CostCenterResponse::fromDomain).collect(Collectors.toList());
    }

}
