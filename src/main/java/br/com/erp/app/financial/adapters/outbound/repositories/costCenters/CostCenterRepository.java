package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenterEntity, Integer> {
}
