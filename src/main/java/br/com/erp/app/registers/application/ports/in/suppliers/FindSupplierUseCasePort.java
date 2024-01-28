package br.com.erp.app.registers.application.ports.in.suppliers;

import br.com.erp.app.registers.application.core.domain.PageableRegisterDomain;
import br.com.erp.app.registers.application.core.domain.PageableRequestRegisterDomain;
import br.com.erp.app.registers.application.core.domain.Supplier;

public interface FindSupplierUseCasePort {
    PageableRegisterDomain<Supplier> getSupplierWithPaginationAndFilter(Supplier supplier, PageableRequestRegisterDomain pageableRequestRegisterDomain);
}
