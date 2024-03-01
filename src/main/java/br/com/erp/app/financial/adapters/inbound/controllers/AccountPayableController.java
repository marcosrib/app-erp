package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.AccountPayableRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.AccountPayableResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.PageFinancialResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.AccountPayableApi;
import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.accountspayable.CreateAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.in.accountspayable.FindAccountPayableUseCasePort;
import br.com.erp.app.financial.application.ports.in.accountspayable.UpdateAccountPayableUseCasePort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-payable")
public class AccountPayableController implements AccountPayableApi {
    private final CreateAccountPayableUseCasePort createAccountPayableUseCasePort;
    private final UpdateAccountPayableUseCasePort updateAccountPayableUseCasePort;

    private final FindAccountPayableUseCasePort findAccountPayableUseCasePort;

    public AccountPayableController(
            CreateAccountPayableUseCasePort createAccountPayableUseCasePort,
            UpdateAccountPayableUseCasePort updateAccountPayableUseCasePort,
            FindAccountPayableUseCasePort findAccountPayableUseCasePort
    ) {
        this.createAccountPayableUseCasePort = createAccountPayableUseCasePort;
        this.updateAccountPayableUseCasePort = updateAccountPayableUseCasePort;
        this.findAccountPayableUseCasePort = findAccountPayableUseCasePort;
    }

    @GetMapping("/pagination")
    @ResponseStatus(HttpStatus.OK)
    public PageFinancialResponse<AccountPayableResponse> findPagination(@RequestParam(required = false) String status, Pageable pageable) {
        var pageableRequestDomain = new PageableFinancialRequestDomain(pageable.getPageNumber(), pageable.getPageSize());
        var filter = AccountPayable
                .builder()
                .status(status)
                .build();
        var accountsPayable = findAccountPayableUseCasePort.getAccountPayableWithPaginationAndFilter(filter, pageableRequestDomain);
        var accountPayableResponses = AccountPayableResponse.fromDomainToList(accountsPayable.data());
        return new PageFinancialResponse<>(
                accountPayableResponses,
                accountsPayable.totalPages(),
                accountsPayable.totalElements(),
                accountsPayable.nextPage(),
                accountsPayable.previousPage(),
                accountsPayable.currentPage()
        );
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
