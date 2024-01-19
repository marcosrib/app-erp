package br.com.erp.app.users.adapters.outbound.repositories.abilities;

import br.com.erp.app.users.adapters.outbound.repositories.entity.AbilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AbilityRepository extends JpaRepository<AbilityEntity, Long> {
    Set<AbilityEntity> findByIdNotIn(List<Long> ids);

    Set<AbilityEntity> findByAbilityGroupId(Long id);
}

