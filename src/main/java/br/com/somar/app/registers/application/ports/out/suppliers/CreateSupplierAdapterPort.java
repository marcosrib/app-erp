package br.com.somar.app.registers.application.ports.out.suppliers;

import br.com.somar.app.registers.application.core.domain.Supplier;

public interface CreateSupplierAdapterPort {
    void create(Supplier supplier);
}
