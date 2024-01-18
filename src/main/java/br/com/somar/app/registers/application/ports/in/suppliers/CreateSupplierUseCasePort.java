package br.com.somar.app.registers.application.ports.in.suppliers;

import br.com.somar.app.registers.application.core.domain.Supplier;

public interface CreateSupplierUseCasePort {
    void create(Supplier supplier);
}
