package br.com.erp.app.financial.application.core.usecases.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.accountspayable.FindAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.out.accountspayable.FindAccountPayableAdapterPort;

public class FindAccountPayableUseCase  implements FindAccountPayableUseCasePort {

    private final FindAccountPayableAdapterPort findAccountPayableAdapterPort;

    public FindAccountPayableUseCase(FindAccountPayableAdapterPort findAccountPayableAdapterPort) {
        this.findAccountPayableAdapterPort = findAccountPayableAdapterPort;
    }

    @Override
    public PageableFinancialDomain<AccountPayable> getAccountPayableWithPaginationAndFilter(AccountPayable filter, PageableFinancialRequestDomain pageable) {
        return findAccountPayableAdapterPort.findAllPagination(filter, pageable);
    }
}
