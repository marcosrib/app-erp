package br.com.erp.app.financial.application.ports.in.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.core.domain.filters.AccountPayableFilter;

public interface FindAccountPayableUseCasePort {
    PageableFinancialDomain<AccountPayable>  getAccountPayableWithPaginationAndFilter(AccountPayableFilter filter, PageableFinancialRequestDomain pageable);
}
