package br.com.erp.app.registers.application.ports.in.suppliers;

import br.com.erp.app.registers.application.core.domain.Supplier;

public interface UpdateSupplierUseCasePort {
    void update(Supplier supplier, Long id);

}
