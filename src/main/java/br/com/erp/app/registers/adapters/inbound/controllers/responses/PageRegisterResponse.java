package br.com.erp.app.registers.adapters.inbound.controllers.responses;

import lombok.Getter;

import java.util.List;
@Getter
public class PageRegisterResponse<T>{
    private List<T> data;
    private int totalPages;
    private long totalElements;
    private int nextPage;
    private int previousPage;
    private int currentPage;

    public static PageRegisterResponse builder() {
        return new PageRegisterResponse();
    }

    public PageRegisterResponse<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public PageRegisterResponse<T> totalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public PageRegisterResponse<T> totalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public PageRegisterResponse<T> currentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public PageRegisterResponse<T> nextPage(int nextPage) {
        this.nextPage = nextPage;
        return this;
    }

    public PageRegisterResponse<T> previousPage(int previousPage) {
        this.previousPage = previousPage;
        return this;
    }
}
