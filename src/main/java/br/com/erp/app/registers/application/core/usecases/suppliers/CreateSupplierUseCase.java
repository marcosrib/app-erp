package br.com.erp.app.registers.application.core.usecases.suppliers;

import br.com.erp.app.common.exceptions.ResourceAlreadyExistsException;
import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;

public class CreateSupplierUseCase implements CreateSupplierUseCasePort {

    private final CreateSupplierAdapterPort createSupplierAdapterPort;

    public CreateSupplierUseCase(CreateSupplierAdapterPort createSupplierAdapterPort) {
        this.createSupplierAdapterPort = createSupplierAdapterPort;
    }

    @Override
    @Transactional
    public void create(Supplier supplier) {
        try {
            createSupplierAdapterPort.create(supplier);
        } catch (DataIntegrityViolationException ex) {
            throw new ResourceAlreadyExistsException("email.already.exists");
        }
    }
}
