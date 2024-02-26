package br.com.erp.app.financial.application.core.domain.enums;

public enum CharAccountTypeEnum {
    EXPENSE("Despesa"),
    REVENUE("Receita");

    private String description;

    CharAccountTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
