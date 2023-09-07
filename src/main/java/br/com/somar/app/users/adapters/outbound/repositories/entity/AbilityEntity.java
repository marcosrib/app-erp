package br.com.somar.app.users.adapters.outbound.repositories.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "abilities")
public class AbilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ability_category_id")
    private AbilityCategoryEntity abilityCategory;

    @ManyToOne
    @JoinColumn(name = "ability_group_id")
    private AbilityGroupEntity abilityGroup;
}
