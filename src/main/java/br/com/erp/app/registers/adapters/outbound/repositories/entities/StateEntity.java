package br.com.erp.app.registers.adapters.outbound.repositories.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "STATES")
public class StateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "CODE", length = 2)
    private String code;

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
