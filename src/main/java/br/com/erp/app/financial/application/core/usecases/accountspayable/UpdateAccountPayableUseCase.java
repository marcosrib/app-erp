package br.com.erp.app.financial.application.core.usecases.accountspayable;

import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.ports.in.accountspayable.UpdateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.out.accountspayable.FindAccountPayableAdapterPort;
import br.com.erp.app.financial.application.ports.out.accountspayable.UpdateAccountPayableAdapterPort;

public class UpdateAccountPayableUseCase implements UpdateAccountPayableUseCasePort  {
    private final UpdateAccountPayableAdapterPort updateAccountPayableAdapterPort;
    private final FindAccountPayableAdapterPort findAccountPayableAdapterPort;

    public UpdateAccountPayableUseCase(UpdateAccountPayableAdapterPort updateAccountPayableAdapterPort, FindAccountPayableAdapterPort findAccountPayableAdapterPort) {
        this.updateAccountPayableAdapterPort = updateAccountPayableAdapterPort;
        this.findAccountPayableAdapterPort = findAccountPayableAdapterPort;
    }

    @Override
    public void update(AccountPayable accountPayable, Long id) {
       var accountPayableActual = findAccountPayableAdapterPort.findById(id);
        var accountPayableUpdated =  AccountPayable
                .builder()
                .id(accountPayableActual.id())
                .dueDate(accountPayable.dueDate())
                .paymentDate(accountPayable.paymentDate())
                .costCenter(new CostCenter(accountPayable.costCenter().id()))
                .chartAccount(new ChartAccount(accountPayable.chartAccount().id()))
                .status(accountPayable.status())
                .value(accountPayable.value())
                .createdAt(accountPayable.createdAt())
                .build();
        updateAccountPayableAdapterPort.update(accountPayableUpdated);
    }
}
