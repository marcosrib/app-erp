package br.com.erp.app.registers.adapters.outbound.repositories.suppliers;

import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import br.com.erp.app.registers.application.core.domain.Supplier;

public class SupplierEntityMapper {
    public static SupplierEntity convertSupplierToSupplierEntity(Supplier supplier) {
        return  SupplierEntity
                .builder()
                .email(supplier.getEmail())
                .companyName(supplier.getCompanyName())
                .phoneNumber(supplier.getPhoneNumber())
                .type(supplier.getTypeOfPerson())
                .cpfCnpj(supplier.getCpfCnpj())
                .cellPhoneNumber(supplier.getCellPhone())
                .fantasyName(supplier.getFantasyName())
                .build();
    }
}
