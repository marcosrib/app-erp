package br.com.erp.app.registers.adapters.outbound.repositories.suppliers;

import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import br.com.erp.app.registers.application.core.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Page<SupplierEntity> findAll(Specification<Supplier> spec, Pageable pageable);
}
