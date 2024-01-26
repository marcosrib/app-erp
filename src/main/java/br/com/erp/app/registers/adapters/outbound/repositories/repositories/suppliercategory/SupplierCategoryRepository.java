package br.com.erp.app.registers.adapters.outbound.repositories.repositories.suppliercategory;

import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierCategoryRepository extends JpaRepository<SupplierEntity, Integer> {
}
