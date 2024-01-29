package br.com.erp.app.registers.adapters.outbound.repositories.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateSupplierAdapter implements CreateSupplierAdapterPort {

    private final SupplierRepository supplierRepository;

    public CreateSupplierAdapter(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    @Transactional
    public void create(Supplier supplier) {
        supplierRepository.save(SupplierEntityMapper.convertSupplierToSupplierEntity(supplier));
    }
}
