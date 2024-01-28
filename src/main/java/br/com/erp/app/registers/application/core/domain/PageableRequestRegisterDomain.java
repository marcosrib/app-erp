package br.com.erp.app.registers.application.core.domain;

public record PageableRequestRegisterDomain(
        int page,
        int size
) {
}
