package br.com.erp.app.financial.application.core.domain;

public record PageableFinancialRequestDomain(
        int page,
        int size
) {
}
