package br.com.erp.app.financial.application.core.usecases.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.ports.in.accountspayable.CreateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.out.accountspayable.CreateAccountPayableAdapterPort;

public class CreateAccountPayableUseCase implements CreateAccountPayableUseCasePort {
    private final CreateAccountPayableAdapterPort createAccountPayableAdapterPort;

    public CreateAccountPayableUseCase(CreateAccountPayableAdapterPort createAccountPayableAdapterPort) {
        this.createAccountPayableAdapterPort = createAccountPayableAdapterPort;
    }

    @Override
    public void create(AccountPayable accountPayable) {
        createAccountPayableAdapterPort.create(accountPayable);
    }
}
