package br.com.erp.app.financial.application.core.domain;

import java.util.List;

public class PageableFinancialDomain<T> {

    private List<T> data;
    private int totalPages;
    private long totalElements;
    private int nextPage;
    private int previousPage;

    private int currentPage;

    public static PageableFinancialDomain builder() {
        return new PageableFinancialDomain();
    }

    public List<T> getData() {
        return data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PageableFinancialDomain<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public PageableFinancialDomain<T> totalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public PageableFinancialDomain<T> totalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public PageableFinancialDomain<T> currentPage(int currentPage) {
        this.currentPage = currentPage + 1;
        return this;
    }

    public PageableFinancialDomain<T> nextPage() {
        if (this.currentPage > totalPages) {
            this.nextPage = totalPages;
            return this;
        }
        this.nextPage = this.currentPage + 1;
        return this;
    }

    public PageableFinancialDomain<T> previousPage() {
        if (this.currentPage == 1) {
            this.previousPage = this.currentPage;
            return this;
        }
        this.previousPage = this.currentPage - 1;
        return this;
    }
}
