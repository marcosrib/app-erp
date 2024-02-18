package br.com.erp.app.financial.application.core.domain;

import br.com.erp.app.financial.application.core.domain.builders.PageableFinancialDomainBuilder;

import java.util.List;

public record PageableFinancialDomain<T>(
        List<T> data,
        int totalPages,
        long totalElements,
        int nextPage,
        int previousPage,
        int currentPage
) {
    public static PageableFinancialDomainBuilder builder() {
        return new PageableFinancialDomainBuilder();
    }

}
