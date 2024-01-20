package br.com.erp.app.registers.adapters.outbound.repositories.repositories.suppliers;

import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierCategoryEntity, Long> {
}
