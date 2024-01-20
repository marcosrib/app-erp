package br.com.erp.app.registers.application.ports.out.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;

public interface UpdateSupplierAdapterPort {
    void update(Supplier supplier);
}
