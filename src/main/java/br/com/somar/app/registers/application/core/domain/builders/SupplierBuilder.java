package br.com.somar.app.registers.application.core.domain.builders;

import br.com.somar.app.registers.application.core.domain.Supplier;
import br.com.somar.app.registers.application.core.domain.enums.SupplierTypeEnum;

public class SupplierBuilder {
    private Long id;
    private String fantasyName;
    private String companyName;
    private String email;
    private String cellPhone;
    private String phone;
    private String cpfCnpj;
    private SupplierTypeEnum type;

    public SupplierBuilder id(Long id) {
        this.id = id;
        return this;
    }
    public SupplierBuilder fantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
        return this;
    }
    public SupplierBuilder companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
    public SupplierBuilder email(String email) {
        this.email = email;
        return this;
    }
    public SupplierBuilder cellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }
    public SupplierBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public SupplierBuilder cpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }
    public SupplierBuilder type(SupplierTypeEnum type) {
        this.type = type;
        return this;
    }

    public Supplier build() {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setCompanyName(companyName);
        supplier.setFantasyName(fantasyName);
        supplier.setEmail(email);
        supplier.setPhone(phone);
        supplier.setType(type);
        supplier.setCellPhone(cellPhone);
        supplier.setCpfCnpj(cpfCnpj);
        return supplier;
    }
}
