package br.com.erp.app.registers.application.core.domain.builders;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeOfPersonEnum;

public class SupplierBuilder {
    private Long id;
    private String fantasyName;
    private String companyName;
    private String email;
    private String cellPhoneNumber;
    private String phoneNumber;
    private String cpfCnpj;
    private SupplierTypeOfPersonEnum typeOfPerson;

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

    public SupplierBuilder cellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
        return this;
    }

    public SupplierBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SupplierBuilder cpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public SupplierBuilder typeOfPerson(SupplierTypeOfPersonEnum typeOfPerson) {
        this.typeOfPerson = typeOfPerson;
        return this;
    }

    public Supplier build() {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setCompanyName(companyName);
        supplier.setFantasyName(fantasyName);
        supplier.setEmail(email);
        supplier.setPhoneNumber(phoneNumber);
        supplier.setTypeOfPerson(typeOfPerson);
        supplier.setCellPhoneNumber(cellPhoneNumber);
        supplier.setCpfCnpj(cpfCnpj);
        return supplier;
    }
}
