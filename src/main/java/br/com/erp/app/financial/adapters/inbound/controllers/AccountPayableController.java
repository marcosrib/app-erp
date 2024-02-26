package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.AccountPayableRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.AccountPayableApi;
import br.com.erp.app.financial.application.ports.in.accountspayable.CreateAccountPayableUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-payable")
public class AccountPayableController implements AccountPayableApi {
    private final CreateAccountPayableUseCasePort createAccountPayableUseCasePort;

    public AccountPayableController(CreateAccountPayableUseCasePort createAccountPayableUseCasePort) {
        this.createAccountPayableUseCasePort = createAccountPayableUseCasePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void create(@RequestBody AccountPayableRequest accountPayableRequest) {
        createAccountPayableUseCasePort.create(accountPayableRequest.toAccountPayableDomain());
    }
}
