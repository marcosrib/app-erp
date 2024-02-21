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
@Table(name = "ADDRESSES")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "NUMBER", length = 10)
    private String number;

    @Column(name = "CEP", length = 10)
    private String cep;

    @Column(name = "COMPLEMENT", length = 50)
    private String complement;

    @Column(name = "CITY", length = 150)
    private String city;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private StateEntity state;

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
