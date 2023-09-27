package br.com.somar.app.users.application.core.domain;

public record PageableRequestDomain(
        int page,
        int size
) {
}
