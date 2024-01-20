package br.com.erp.app.registers.adapters.outbound.repositories.entities;

import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fantasy_name", length = 150)
    private String fantasyName;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "cell_phone_number", length = 9)
    private String cellPhoneNumber;

    @Column(name = "phone_number", length = 9)
    private String phoneNumber;

    @Column(name = "cpf_cnpj", length = 14)
    private String cpfCnpj;

    @Column(name = "type", length = 2)
    @Enumerated(EnumType.STRING)
    private SupplierTypeEnum type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
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
