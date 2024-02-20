package br.com.erp.app.financial.application.core.usecases.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.chartAccountsGroup.FindChartAccountsGroupUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.FindChartAccountsGroupAdapterPort;

import java.util.List;

public class FindChartAccountsGroupUseCase implements FindChartAccountsGroupUseCasePort {
    private final FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort;

    public FindChartAccountsGroupUseCase(FindChartAccountsGroupAdapterPort findChartAccountsGroupAdapterPort) {
        this.findChartAccountsGroupAdapterPort = findChartAccountsGroupAdapterPort;
    }

    @Override
    public List<ChartAccountsGroup> findAllChartAccountsGroup() {
        return findChartAccountsGroupAdapterPort.findAll();
    }

    @Override
    public PageableFinancialDomain getChartAccountsGroupWithPaginationAndFilter(String name, PageableFinancialRequestDomain pageable) {
        return findChartAccountsGroupAdapterPort.findAllPagination(name, pageable);
    }
}
