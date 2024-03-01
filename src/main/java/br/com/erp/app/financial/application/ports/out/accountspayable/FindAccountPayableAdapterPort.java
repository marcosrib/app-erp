package br.com.erp.app.financial.application.ports.out.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;

public interface FindAccountPayableAdapterPort {
    AccountPayable findById(Long id);
    PageableFinancialDomain<AccountPayable> findAllPagination(AccountPayable filter, PageableFinancialRequestDomain pageable);
}
