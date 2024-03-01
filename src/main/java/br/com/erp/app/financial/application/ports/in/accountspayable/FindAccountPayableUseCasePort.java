package br.com.erp.app.financial.application.ports.in.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

public interface FindAccountPayableUseCasePort {
    PageableFinancialDomain<AccountPayable>  getAccountPayableWithPaginationAndFilter(AccountPayable filter, PageableFinancialRequestDomain pageable);
}
