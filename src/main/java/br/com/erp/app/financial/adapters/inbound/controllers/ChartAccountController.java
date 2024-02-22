package br.com.erp.app.financial.adapters.inbound.controllers;

import br.com.erp.app.financial.adapters.inbound.controllers.requests.ChartAccountRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.swagger.api.ChartAccountApi;
import br.com.erp.app.financial.application.ports.in.chartaccounts.CreateChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.in.chartaccounts.UpdateChartAccountUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chart-account")
public class ChartAccountController implements ChartAccountApi {

    private final UpdateChartAccountUseCasePort updateChartAccountUseCasePort;

    private final CreateChartAccountUseCasePort createChartAccountUseCasePort;

    public ChartAccountController(UpdateChartAccountUseCasePort updateChartAccountUseCasePort, CreateChartAccountUseCasePort createChartAccountUseCasePort) {
        this.updateChartAccountUseCasePort = updateChartAccountUseCasePort;
        this.createChartAccountUseCasePort = createChartAccountUseCasePort;
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
