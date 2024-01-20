package br.com.erp.app.registers.adapters.outbound.repositories.repositories.suppliers;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.out.suppliers.FindSupplierAdapterPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindSupplierAdapter implements FindSupplierAdapterPort {
    private final SupplierRepository supplierRepository;

    public FindSupplierAdapter(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Supplier findSupplierById(Long id) {
        var supplierEntity = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("supplier.not.exist"));
        return Supplier.convertsupplierEntityToSupplier(supplierEntity);
    }
}
