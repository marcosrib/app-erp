package br.com.somar.app.registers.application.core.domain;

import br.com.somar.app.registers.application.core.domain.enums.SupplierTypeEnum;

public class Supplier {
    private Long id;
    private String fantasyName;
    private String companyName;
    private String email;
    private String cellPhone;
    private String phone;
    private String cpfCnpj;
    private SupplierTypeEnum type;

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
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
