package br.com.erp.app.registers.adapters.outbound.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service_providers")
public class ServiceProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fantasy_name", length = 150)
    private String fantasyName;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "cell_phone", length = 9)
    private String cellPhone;

    @Column(name = "phone", length = 9)
    private String phone;

    @Column(name = "cpf_cnpj", length = 14)
    private String cpfCnpj;

    @Column(name = "type", length = 2)
    private String type;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
