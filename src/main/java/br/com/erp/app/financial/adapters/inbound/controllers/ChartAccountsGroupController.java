package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.ChartAccountsGroupRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.ChartAccountsGroupResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.PageFinancialResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.ChartAccountsGroupApi;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.CreateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.FindChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccountsgroup.UpdateChartAccountsGroupUseCasePort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chart-accounts-group")
public class ChartAccountsGroupController implements ChartAccountsGroupApi {

    private final CreateChartAccountsGroupUseCasePort createChartAccountsGroupUseCasePort;

    private final UpdateChartAccountsGroupUseCasePort updateChartAccountsGroupUseCasePort;

    private final FindChartAccountsGroupUseCasePort findChartAccountsGroupUseCasePort;

    public ChartAccountsGroupController(CreateChartAccountsGroupUseCasePort createChartAccountsGroupUseCasePort, UpdateChartAccountsGroupUseCasePort updateChartAccountsGroupUseCasePort, FindChartAccountsGroupUseCasePort findChartAccountsGroupUseCasePort) {
        this.createChartAccountsGroupUseCasePort = createChartAccountsGroupUseCasePort;
        this.updateChartAccountsGroupUseCasePort = updateChartAccountsGroupUseCasePort;
        this.findChartAccountsGroupUseCasePort = findChartAccountsGroupUseCasePort;
    }

    @GetMapping
    @Override
    public List<ChartAccountsGroupResponse> index() {
        var chartAccountsGroups = findChartAccountsGroupUseCasePort.findAllChartAccountsGroup();
        return ChartAccountsGroupResponse.fromDomainToList(chartAccountsGroups);
    }
    @GetMapping("/pagination")
    @ResponseStatus(HttpStatus.OK)
    public PageFinancialResponse findPagination(@RequestParam(required = false) String name, Pageable pageable) {
        var pageableRequestDomain = new PageableFinancialRequestDomain(pageable.getPageNumber(), pageable.getPageSize());
        var chartAccountsGroup = findChartAccountsGroupUseCasePort.getChartAccountsGroupWithPaginationAndFilter(name, pageableRequestDomain);
        var chartAccountsGroupsList = ChartAccountsGroupResponse.fromDomainToList(chartAccountsGroup.data());
        return  new PageFinancialResponse<ChartAccountsGroupResponse>(
                chartAccountsGroupsList,
                chartAccountsGroup.totalPages(),
                chartAccountsGroup.totalElements(),
                chartAccountsGroup.nextPage(),
                chartAccountsGroup.previousPage(),
                chartAccountsGroup.currentPage()
        );
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void create(@RequestBody ChartAccountsGroupRequest chartAccountsGroupRequest) {
        createChartAccountsGroupUseCasePort.create(chartAccountsGroupRequest.toChartAccountsGroupDomain());
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void update(@RequestBody ChartAccountsGroupRequest chartAccountsGroupRequest, @PathVariable Integer id) {
        updateChartAccountsGroupUseCasePort.update(chartAccountsGroupRequest.toChartAccountsGroupDomain(), id);
    }


}
