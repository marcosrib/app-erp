package br.com.somar.app.users.adapters.inbound.controllers.responses.users;

import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> data;
    private int totalPages;
    private long totalElements;
    private int nextPage;
    private int previousPage;
    private int currentPage;
}
