package br.com.erp.app.financial.adapters.inbound.controllers.responses;

import java.util.List;

public record PageFinancialResponse<T>(
        List<T> data,
        int totalPages,
        long totalElements,
        int nextPage,
        int previousPage,
        int currentPage
) {
}
