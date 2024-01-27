package br.com.erp.app.users.adapters.outbound.repositories.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ABILITIES")
public class AbilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ABILITY_CATEGORY_ID")
    private AbilityCategoryEntity abilityCategory;

    @ManyToOne
    @JoinColumn(name = "ABILITY_GROUP_ID")
    private AbilityGroupEntity abilityGroup;
}
