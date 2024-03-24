package br.com.erp.app.financial.application.ports.out.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.core.domain.filters.AccountPayableFilter;

public interface FindAccountPayableAdapterPort {
    AccountPayable findById(Long id);
    PageableFinancialDomain<AccountPayable> findAllPagination(AccountPayableFilter filter, PageableFinancialRequestDomain pageable);
}
