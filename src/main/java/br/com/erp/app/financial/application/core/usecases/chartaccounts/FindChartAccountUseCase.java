package br.com.erp.app.financial.application.core.usecases.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.in.chartaccounts.FindChartAccountUseCasePort;
import br.com.erp.app.financial.application.ports.out.chartaccounts.FindChartAccountAdapterPort;

import java.util.List;

public class FindChartAccountUseCase implements FindChartAccountUseCasePort {
    private final FindChartAccountAdapterPort findChartAccountAdapterPort;

    public FindChartAccountUseCase(FindChartAccountAdapterPort findChartAccountAdapterPort) {
        this.findChartAccountAdapterPort = findChartAccountAdapterPort;
    }
    @Override
    public PageableFinancialDomain<ChartAccount> getChartAccountWithPaginationAndFilter(String name, PageableFinancialRequestDomain pageable) {
        return findChartAccountAdapterPort.findAllPagination(name, pageable);
    }

    @Override
    public List<ChartAccount> getChartAccounts() {
        return findChartAccountAdapterPort.findAllChartAccount();
    }
}
