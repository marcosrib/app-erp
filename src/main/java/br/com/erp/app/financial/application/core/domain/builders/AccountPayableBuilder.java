package br.com.erp.app.financial.application.core.domain.builders;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;
import br.com.erp.app.registers.application.core.domain.Supplier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountPayableBuilder {

    private Long id;
    private BigDecimal value;
    private AccountPayableStatusEnum status;
    private ChartAccount chartAccount;
    private Supplier supplier;
    private CostCenter costCenter;
    private LocalDateTime paymentDate;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AccountPayableBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AccountPayableBuilder value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public AccountPayableBuilder status(AccountPayableStatusEnum status) {
        this.status = status;
        return this;
    }

    public AccountPayableBuilder chartAccount(ChartAccount chartAccount) {
        this.chartAccount = chartAccount;
        return this;
    }

    public AccountPayableBuilder supplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public AccountPayableBuilder costCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
        return this;
    }
    public AccountPayableBuilder paymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }
    public AccountPayableBuilder dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public AccountPayableBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }


    public AccountPayableBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }


    public AccountPayable build() {

        return new AccountPayable(
                id,
                value,
                status,
                chartAccount,
                supplier,
                costCenter,
                paymentDate,
                dueDate,
                createdAt,
                updatedAt
        );
    }
}
