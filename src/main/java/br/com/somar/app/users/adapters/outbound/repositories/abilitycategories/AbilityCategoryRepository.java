package br.com.somar.app.users.adapters.outbound.repositories.abilitycategories;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityCategoryRepository extends JpaRepository<AbilityCategoryEntity, Long> {
}
