package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.AccountPayableRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.AccountPayableApi;
import br.com.erp.app.financial.application.ports.in.accountspayable.CreateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.in.accountspayable.UpdateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.out.accountspayable.UpdateAccountPayableAdapterPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-payable")
public class AccountPayableController implements AccountPayableApi {
    private final CreateAccountPayableUseCasePort createAccountPayableUseCasePort;
    private final UpdateAccountPayableUseCasePort updateAccountPayableUseCasePort;
    public AccountPayableController(CreateAccountPayableUseCasePort createAccountPayableUseCasePort, UpdateAccountPayableAdapterPort updateAccountPayableAdapterPort, UpdateAccountPayableUseCasePort updateAccountPayableUseCasePort) {
        this.createAccountPayableUseCasePort = createAccountPayableUseCasePort;
        this.updateAccountPayableUseCasePort = updateAccountPayableUseCasePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void create(@RequestBody AccountPayableRequest accountPayableRequest) {
        createAccountPayableUseCasePort.create(accountPayableRequest.toAccountPayableDomain());
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void update(@RequestBody AccountPayableRequest accountPayableRequest, @PathVariable Long id) {
        updateAccountPayableUseCasePort.update(accountPayableRequest.toAccountPayableDomain(), id);
    }
}
