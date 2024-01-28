package br.com.erp.app.registers.adapters.inbound.controllers.requests;

import br.com.erp.app.registers.application.core.domain.Supplier;

public record SupplierFilterRequest(String email) {
    public Supplier toSupplierDomain() {
        return Supplier.builder().email(email).build();
    }
}
