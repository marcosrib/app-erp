package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.CostCenterRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.CostCenterResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.PageFinancialResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.CostCenterApi;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.costcenters.CreateCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.in.costcenters.FindCostCenterUseCasePort;
import br.com.erp.app.financial.application.ports.in.costcenters.UpdateCostCenterUseCasePort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cost-center")
public class CostCenterController implements CostCenterApi {

    private final CreateCostCenterUseCasePort createCostCenterUseCasePort;
    private final UpdateCostCenterUseCasePort updateCostCenterUseCasePort;
    private final FindCostCenterUseCasePort findCostCenterUseCasePort;

    public CostCenterController(CreateCostCenterUseCasePort createCostCenterUseCasePort, UpdateCostCenterUseCasePort updateCostCenterUseCasePort, FindCostCenterUseCasePort findCostCenterUseCasePort) {
        this.createCostCenterUseCasePort = createCostCenterUseCasePort;
        this.updateCostCenterUseCasePort = updateCostCenterUseCasePort;
        this.findCostCenterUseCasePort = findCostCenterUseCasePort;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PageFinancialResponse<CostCenterResponse> index(CostCenterRequest filter, Pageable pageable) {
        var pageableRequestDomain = new PageableFinancialRequestDomain(pageable.getPageNumber(), pageable.getPageSize());
        var costCenters = findCostCenterUseCasePort.getCostCentersWithPaginationAndFilter(filter.toCostCenterDomain(), pageableRequestDomain);
        var costCenterResponseList = CostCenterResponse.fromDomainToList(costCenters.getData());
        return new PageFinancialResponse<CostCenterResponse>(
                costCenterResponseList,
                costCenters.getTotalPages(),
                costCenters.getTotalElements(),
                costCenters.getNextPage(),
                costCenters.getPreviousPage(),
                costCenters.getCurrentPage()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void create(@RequestBody CostCenterRequest costCenterRequest) {
        createCostCenterUseCasePort.create(costCenterRequest.toCostCenterDomain());
    }
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void update(@RequestBody CostCenterRequest costCenterRequest, @PathVariable Integer id) {
        updateCostCenterUseCasePort.update(costCenterRequest.toCostCenterDomain(), id);
    }


}
