package br.com.erp.app.financial.application.ports.in.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;

public interface UpdateAccountPayableUseCasePort {
    void update(AccountPayable accountPayable);
}
