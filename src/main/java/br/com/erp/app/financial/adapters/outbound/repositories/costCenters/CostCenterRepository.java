package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenterEntity, Integer> {

    Page<CostCenterEntity> findAll(Specification<CostCenterEntity> spec, Pageable pageable);
}
