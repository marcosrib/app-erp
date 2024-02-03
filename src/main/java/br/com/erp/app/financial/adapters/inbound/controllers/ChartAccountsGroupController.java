package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.ChartAccountsGroupRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.ChartAccountsGroupResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.ChartAccountsGroupApi;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.CreateChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.FindChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.UpdateChartAccountsGroupUseCasePort;
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
