package br.com.erp.app.registers.application.ports.out.suppliers;

import br.com.erp.app.registers.application.core.domain.PageableRegisterDomain;
import br.com.erp.app.registers.application.core.domain.PageableRequestRegisterDomain;
import br.com.erp.app.registers.application.core.domain.Supplier;

public interface FindSupplierAdapterPort {
    Supplier findSupplierById(Long id);
    PageableRegisterDomain<Supplier> findSuppliersWithPagination(Supplier supplier, PageableRequestRegisterDomain pageable);
}
