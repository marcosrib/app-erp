package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.ports.out.accountspayable.FindAccountPayableAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class FindAccountPayableAdapter implements FindAccountPayableAdapterPort {
  private  final AccountPayableRepository accountPayableRepository;

    public FindAccountPayableAdapter(AccountPayableRepository accountPayableRepository) {
        this.accountPayableRepository = accountPayableRepository;
    }

    @Override
    public AccountPayable findById(Long id) {
        var accountPayable  = accountPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("account.payable.not.found"));

        return AccountPayable.convertAccountPayableEntityToAccountPayable(accountPayable);
    }
}
