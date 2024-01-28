package br.com.erp.app.registers.application.core.usecases.suppliers;

import br.com.erp.app.registers.application.core.domain.PageableRegisterDomain;
import br.com.erp.app.registers.application.core.domain.PageableRequestRegisterDomain;
import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.in.suppliers.FindSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.out.suppliers.FindSupplierAdapterPort;

public class FindSupplierUseCase implements FindSupplierUseCasePort {

    private final FindSupplierAdapterPort findSupplierAdapterPort;

    public FindSupplierUseCase(FindSupplierAdapterPort findSupplierAdapterPort) {
        this.findSupplierAdapterPort = findSupplierAdapterPort;
    }

    @Override
    public PageableRegisterDomain<Supplier> getSupplierWithPaginationAndFilter(Supplier supplier, PageableRequestRegisterDomain pageableRequestRegisterDomain) {
        return findSupplierAdapterPort.findSuppliersWithPagination(supplier, pageableRequestRegisterDomain);
    }
}
