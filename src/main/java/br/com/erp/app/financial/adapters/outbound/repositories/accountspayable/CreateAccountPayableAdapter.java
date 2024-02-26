package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.ports.out.accountspayable.CreateAccountPayableAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountPayableAdapter implements CreateAccountPayableAdapterPort {
    private final AccountPayableRepository accountsPayableRepository;

    public CreateAccountPayableAdapter(AccountPayableRepository accountsPayableRepository) {
        this.accountsPayableRepository = accountsPayableRepository;
    }

    @Override
    public void create(AccountPayable accountPayable) {
     var accountPayableEntity = AccountPayableEntityMapper.convertAccountPayableToAccountPayableEntity(accountPayable);
        accountsPayableRepository.save(accountPayableEntity);
    }
}
