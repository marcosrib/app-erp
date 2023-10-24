package br.com.somar.app.users.adapters.outbound.repositories.abilitycategories;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AbilityCategoryRepository extends JpaRepository<AbilityCategoryEntity, Long> {

    List<AbilityCategoryEntity>  findByCodeIn(List<String> codes);
}
