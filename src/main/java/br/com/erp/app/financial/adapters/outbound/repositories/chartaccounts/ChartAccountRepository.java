package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartAccountRepository extends JpaRepository<ChartAccountEntity, Integer> {
    Page<ChartAccountEntity> findAll(Specification<ChartAccountEntity> spec, Pageable page);
}
