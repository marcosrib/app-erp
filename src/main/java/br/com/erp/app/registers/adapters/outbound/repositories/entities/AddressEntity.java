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
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "complement", length = 50)
    private String complement;

    @Column(name = "city", length = 150)
    private String city;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity state;

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
