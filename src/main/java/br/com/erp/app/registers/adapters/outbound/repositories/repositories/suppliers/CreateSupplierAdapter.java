package br.com.erp.app.registers.adapters.outbound.repositories.repositories.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierAdapter implements CreateSupplierAdapterPort {

    private final SupplierRepository supplierRepository;

    public CreateSupplierAdapter(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void create(Supplier supplier) {
        supplierRepository.save(SupplierEntityMapper.convertListProfileToListEntity(supplier));
    }
}
