package br.com.erp.app.registers.application.core.domain;

import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import br.com.erp.app.registers.application.core.domain.builders.SupplierBuilder;
import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeEnum;

public class Supplier {
    private Long id;
    private String fantasyName;
    private String companyName;
    private String email;
    private String cellPhoneNumber;
    private String phoneNumber;
    private String cpfCnpj;
    private SupplierTypeEnum type;


    public static Supplier convertsupplierEntityToSupplier(SupplierEntity supplierEntity) {
        return Supplier
                .builder()
                .companyName(supplierEntity.getCompanyName())
                .fantasyName(supplierEntity.getFantasyName())
                .cpfCnpj(supplierEntity.getCpfCnpj())
                .phoneNumber(supplierEntity.getPhoneNumber())
                .cellPhoneNumber(supplierEntity.getCellPhoneNumber())
                .type(supplierEntity.getType())
                .email(supplierEntity.getEmail())
                .build();
    }


    public static SupplierBuilder builder() {
        return new SupplierBuilder();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public SupplierTypeEnum getType() {
        return type;
    }

    public void setType(SupplierTypeEnum type) {
        this.type = type;
    }
}
