package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.ports.out.accountspayable.UpdateAccountPayableAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountPayableAdapter implements UpdateAccountPayableAdapterPort {

    private final AccountPayableRepository accountPayableRepository;

    public UpdateAccountPayableAdapter(AccountPayableRepository accountPayableRepository) {
        this.accountPayableRepository = accountPayableRepository;
    }

    @Override
    public void update(AccountPayable accountPayable) {
        var accountPayableEntity = AccountPayableEntityMapper.convertAccountPayableToAccountPayableEntity(accountPayable);
        accountPayableRepository.save(accountPayableEntity);
    }
}
