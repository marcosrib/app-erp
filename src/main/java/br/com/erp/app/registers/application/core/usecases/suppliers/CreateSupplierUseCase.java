package br.com.erp.app.registers.application.core.usecases.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;

public class CreateSupplierUseCase implements CreateSupplierUseCasePort {

    private final CreateSupplierAdapterPort createSupplierAdapterPort;

    public CreateSupplierUseCase(CreateSupplierAdapterPort createSupplierAdapterPort) {
        this.createSupplierAdapterPort = createSupplierAdapterPort;
    }

    @Override
    public void create(Supplier supplier) {
        createSupplierAdapterPort.create(supplier);
    }
}
