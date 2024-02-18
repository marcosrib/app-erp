package br.com.erp.app.financial.application.core.domain.builders;

import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;

import java.util.List;

public class PageableFinancialDomainBuilder<T> {
    private List<T> data;
    private int totalPages;
    private long totalElements;
    private int nextPage;
    private int previousPage;
    private int currentPage;

    public PageableFinancialDomainBuilder<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public PageableFinancialDomainBuilder<T> totalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public PageableFinancialDomainBuilder<T> totalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public PageableFinancialDomainBuilder<T> currentPage(int currentPage) {
        this.currentPage = currentPage + 1;
        return this;
    }

    public PageableFinancialDomainBuilder<T> nextPage() {
        if (this.currentPage > totalPages) {
            this.nextPage = totalPages;
            return this;
        }
        this.nextPage = this.currentPage + 1;
        return this;
    }

    public PageableFinancialDomainBuilder<T> previousPage() {
        if (this.currentPage == 1) {
            this.previousPage = this.currentPage;
            return this;
        }
        this.previousPage = this.currentPage - 1;
        return this;
    }

    public PageableFinancialDomain build() {
        return new PageableFinancialDomain(data, totalPages, totalElements, nextPage, previousPage, currentPage);
    }
}
