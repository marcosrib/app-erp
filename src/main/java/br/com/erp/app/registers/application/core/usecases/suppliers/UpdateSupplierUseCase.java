package br.com.erp.app.registers.application.core.usecases.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.in.suppliers.UpdateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.out.suppliers.FindSupplierAdapterPort;
import br.com.erp.app.registers.application.ports.out.suppliers.UpdateSupplierAdapterPort;

public class UpdateSupplierUseCase implements UpdateSupplierUseCasePort {

    private final UpdateSupplierAdapterPort updateSupplierAdapterPort;
    private final FindSupplierAdapterPort findSupplierAdapterPort;

    public UpdateSupplierUseCase(UpdateSupplierAdapterPort updateSupplierAdapterPort, FindSupplierAdapterPort findSupplierAdapterPort) {
        this.updateSupplierAdapterPort = updateSupplierAdapterPort;
        this.findSupplierAdapterPort = findSupplierAdapterPort;
    }

    @Override
    public void update(Supplier supplier, Long id) {
        var supplierResult = findSupplierAdapterPort.findSupplierById(id);
        supplierResult.setCellPhoneNumber(supplier.getPhoneNumber());
        supplierResult.setPhoneNumber(supplier.getPhoneNumber());
        supplierResult.setCompanyName(supplier.getCompanyName());
        supplierResult.setEmail(supplier.getEmail());
        supplierResult.setCpfCnpj(supplier.getCpfCnpj());
        supplierResult.setFantasyName(supplier.getFantasyName());
        updateSupplierAdapterPort.update(supplierResult);
    }
}
