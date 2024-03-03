package br.com.erp.app.financial.adapters.outbound.repositories.entities;

import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;
import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS_PAYABLE")
public final class AccountPayableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALUE")
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private AccountPayableStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "CHART_ACCOUNT_ID")
    private ChartAccountEntity chartAccountEntity;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private SupplierEntity supplierEntity;

    @ManyToOne
    @JoinColumn(name = "COST_CENTER_ID")
    private CostCenterEntity costCenterEntity;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now();}

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
