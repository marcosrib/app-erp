package br.com.erp.app.users.adapters.inbound.controllers.responses.users;

import lombok.Getter;

import java.util.List;

@Getter
public class PageResponse<T> {
    private List<T> data;
    private int totalPages;
    private long totalElements;
    private int nextPage;
    private int previousPage;
    private int currentPage;

    public static PageResponse builder() {
        return new PageResponse();
    }

    public PageResponse<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public PageResponse<T> totalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public PageResponse<T> totalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public PageResponse<T> currentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public PageResponse<T> nextPage(int nextPage) {
        this.nextPage = nextPage;
        return this;
    }

    public PageResponse<T> previousPage(int previousPage) {
        this.previousPage = previousPage;
        return this;
    }
}
