package br.com.erp.app.financial.application.ports.out.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;

public interface UpdateAccountPayableAdapterPort {
    void update(AccountPayable accountPayable);
}
