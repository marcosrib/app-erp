package br.com.erp.app.registers.application.ports.out.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;

public interface CreateSupplierAdapterPort {
    void create(Supplier supplier);
}
