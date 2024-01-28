package br.com.erp.app.registers.adapters.outbound.repositories.entities;

import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeOfPersonEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@Entity
@Table(name = "SUPPLIERS")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FANTASY_NAME", length = 150)
    private String fantasyName;

    @Column(name = "COMPANY_NAME", length = 255)
    private String companyName;

    @Column(name = "EMAIL", length = 50, unique = true)
    private String email;

    @Column(name = "CELL_PHONE_NUMBER", length = 9)
    private String cellPhoneNumber;

    @Column(name = "PHONE_NUMBER", length = 9)
    private String phoneNumber;

    @Column(name = "CPF_CNPJ", length = 14)
    private String cpfCnpj;

    @Column(name = "TYPE_OF_PERSON", length = 2)
    @Enumerated(EnumType.STRING)
    private SupplierTypeOfPersonEnum type;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
