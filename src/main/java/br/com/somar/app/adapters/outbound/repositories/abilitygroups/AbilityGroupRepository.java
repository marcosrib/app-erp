package br.com.somar.app.adapters.outbound.repositories.abilitygroups;

import br.com.somar.app.adapters.outbound.repositories.entity.AbilityGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityGroupRepository  extends JpaRepository<AbilityGroupEntity, Long> {
}
