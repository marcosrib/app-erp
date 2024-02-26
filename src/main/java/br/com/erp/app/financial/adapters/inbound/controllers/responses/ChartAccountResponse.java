package br.com.erp.app.financial.adapters.inbound.controllers.responses;

import br.com.erp.app.financial.application.core.domain.ChartAccount;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ChartAccountResponse(
        Integer id,
        String name,
        ChartAccountTypeEnumResponse type,
        ChartAccountsGroupResponse chartAccountsGroup,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static ChartAccountResponse fromDomain(ChartAccount chartAccount) {
        return new ChartAccountResponse(
                chartAccount.id(),
                chartAccount.name(),
                new ChartAccountTypeEnumResponse(chartAccount.type().toString(), chartAccount.type().getDescription()),
                new ChartAccountsGroupResponse(
                        chartAccount.chartAccountsGroup().getId(),
                        chartAccount.chartAccountsGroup().getName()),
                chartAccount.createdAt(),
                chartAccount.updatedAt()
        );
    }

    public static List<ChartAccountResponse> fromDomainToList(List<ChartAccount> chartAccounts) {
        return chartAccounts.stream().map(ChartAccountResponse::fromDomain).collect(Collectors.toList());
    }
}
