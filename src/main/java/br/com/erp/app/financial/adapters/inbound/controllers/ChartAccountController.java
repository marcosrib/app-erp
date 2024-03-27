package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.ChartAccountRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.ChartAccountResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.PageFinancialResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.ChartAccountApi;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.chartaccounts.CreateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccounts.FindChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccounts.UpdateChartAccountUseCasePort;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chart-account")
public class ChartAccountController implements ChartAccountApi {

    private final UpdateChartAccountUseCasePort updateChartAccountUseCasePort;

    private final CreateChartAccountUseCasePort createChartAccountUseCasePort;

    private final FindChartAccountUseCasePort findChartAccountUseCasePort;

    public ChartAccountController(UpdateChartAccountUseCasePort updateChartAccountUseCasePort, CreateChartAccountUseCasePort createChartAccountUseCasePort, FindChartAccountUseCasePort findChartAccountUseCasePort) {
        this.updateChartAccountUseCasePort = updateChartAccountUseCasePort;
        this.createChartAccountUseCasePort = createChartAccountUseCasePort;
        this.findChartAccountUseCasePort = findChartAccountUseCasePort;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChartAccountResponse> index() {
        var chartAccounts = findChartAccountUseCasePort.getChartAccounts();
        return ChartAccountResponse.fromDomainToList(chartAccounts);
    }

    @GetMapping("/pagination")
    @ResponseStatus(HttpStatus.OK)
    public PageFinancialResponse findPagination(@RequestParam(required = false) String name, Pageable pageable) {
        var pageableRequestDomain = new PageableFinancialRequestDomain(pageable.getPageNumber(), pageable.getPageSize());
        var chartAccounts = findChartAccountUseCasePort.getChartAccountWithPaginationAndFilter(name, pageableRequestDomain);
        var chartAccountsGroupsList = ChartAccountResponse.fromDomainToList(chartAccounts.data());
        return new PageFinancialResponse<ChartAccountResponse>(
                chartAccountsGroupsList,
                chartAccounts.totalPages(),
                chartAccounts.totalElements(),
                chartAccounts.nextPage(),
                chartAccounts.previousPage(),
                chartAccounts.currentPage()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void create(@Valid @RequestBody ChartAccountRequest chartAccountRequest) {
        createChartAccountUseCasePort.create(chartAccountRequest.toChartAccountDomain());
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void update(@Valid @RequestBody ChartAccountRequest chartAccountRequest, @PathVariable Integer id) {
        updateChartAccountUseCasePort.update(chartAccountRequest.toChartAccountDomain(), id);
    }

}
