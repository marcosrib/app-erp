package br.com.erp.app.registers.adapters.inbound.controllers.requests;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeEnum;

public record SupplierRequest(
        String fantasyName,
        String companyName,
        String email,
        String cellPhone,
        String phone,
        String cpfCnpj,
        SupplierTypeEnum type
) {
    public Supplier toSupplierDomain() {
        return Supplier
                .builder()
                .companyName(companyName)
                .cellPhone(cellPhone)
                .cpfCnpj(cpfCnpj)
                .fantasyName(fantasyName)
                .phone(phone)
                .email(email)
                .type(type)
                .build();
    }
}
