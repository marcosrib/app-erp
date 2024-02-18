package br.com.erp.app.financial.adapters.outbound.repositories.chartaccountsgroup;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountsGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartAccountsGroupRepository extends JpaRepository<ChartAccountsGroupEntity, Integer> {
}
