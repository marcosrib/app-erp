package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartAccountRepository extends JpaRepository<ChartAccountEntity, Integer> {
}
