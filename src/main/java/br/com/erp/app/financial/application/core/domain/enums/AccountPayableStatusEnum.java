package br.com.erp.app.financial.application.core.domain.enums;

import java.util.Optional;

public enum AccountPayableStatusEnum {

    PAID("Pago"),
    PENDING("Pendente"),

    NONE("Todos");

    private String description;

    AccountPayableStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static AccountPayableStatusEnum from(String text) {
        if("".equals(text)){
           text = null;
        }
        return Optional.ofNullable(text)
                .map(String::toUpperCase)
                .map(AccountPayableStatusEnum::valueOf)
                .orElse(NONE);
    }
}
