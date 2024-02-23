package br.com.erp.app.financial.adapters.inbound.controllers.responses;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ChartAccountsGroupResponse(
        Integer id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {


    public ChartAccountsGroupResponse(Integer id,  String name) {
        this(id, name, null, null);
    }

    public static ChartAccountsGroupResponse fromDomain(ChartAccountsGroup chartAccountsGroup) {
        return new ChartAccountsGroupResponse(
                chartAccountsGroup.getId(),
                chartAccountsGroup.getName(),
                chartAccountsGroup.getCreatedAt(),
                chartAccountsGroup.getUpdatedAt()
        );
    }

    public static List<ChartAccountsGroupResponse> fromDomainToList(List<ChartAccountsGroup> chartAccountsGroups) {
        return chartAccountsGroups.stream().map(ChartAccountsGroupResponse::fromDomain).collect(Collectors.toList());
    }
}
