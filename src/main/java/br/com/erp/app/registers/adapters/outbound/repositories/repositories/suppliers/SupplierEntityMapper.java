package br.com.erp.app.registers.adapters.outbound.repositories.repositories.suppliers;

import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import br.com.erp.app.registers.application.core.domain.Supplier;

public class SupplierEntityMapper {
    public static SupplierEntity convertListProfileToListEntity(Supplier supplier) {
        return  SupplierEntity
                .builder()
                .email(supplier.getEmail())
                .companyName(supplier.getCompanyName())
                .phone(supplier.getPhone())
                .type(supplier.getType())
                .cpfCnpj(supplier.getCpfCnpj())
                .cellPhone(supplier.getCellPhone())
                .fantasyName(supplier.getFantasyName())
                .build();
    }
}
