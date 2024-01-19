package br.com.erp.app.users.application.core.domain;

public record PageableRequestDomain(
        int page,
        int size
) {
}
