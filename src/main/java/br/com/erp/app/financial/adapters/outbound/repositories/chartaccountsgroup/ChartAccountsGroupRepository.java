package br.com.erp.app.financial.adapters.outbound.repositories.chartaccountsgroup;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountsGroupEntity;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartAccountsGroupRepository extends JpaRepository<ChartAccountsGroupEntity, Integer> {
    Page<ChartAccountsGroupEntity> findAll(Specification<ChartAccountsGroupEntity> spec, Pageable pageable);
}
