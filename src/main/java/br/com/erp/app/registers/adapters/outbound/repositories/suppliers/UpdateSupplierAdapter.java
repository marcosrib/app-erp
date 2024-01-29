package br.com.erp.app.registers.adapters.outbound.repositories.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.out.suppliers.UpdateSupplierAdapterPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateSupplierAdapter implements UpdateSupplierAdapterPort {

    private final SupplierRepository supplierRepository;

    public UpdateSupplierAdapter(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    @Override
    @Transactional
    public void update(Supplier supplier) {
        supplierRepository.save(SupplierEntityMapper.convertSupplierToSupplierEntity(supplier));
    }
}
