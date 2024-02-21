package br.com.erp.app.financial.adapters.outbound.repositories.entities;

import br.com.erp.app.financial.application.core.domain.enums.CharAccountTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CHART_ACCOUNTS")
public final class ChartAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 50)
    private CharAccountTypeEnum type;

    @Column(name = "NAME", length = 150)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CHART_ACCOUNTS_GROUP_ID")
    private ChartAccountsGroupEntity chartAccountsGroupEntity;

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
