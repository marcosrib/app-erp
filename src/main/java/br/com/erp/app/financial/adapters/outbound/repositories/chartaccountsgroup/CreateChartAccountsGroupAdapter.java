package br.com.erp.app.financial.adapters.outbound.repositories.chartaccountsgroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.ports.out.chartaccountsgroup.CreateChartAccountsGroupAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateChartAccountsGroupAdapter implements CreateChartAccountsGroupAdapterPort {
    private final ChartAccountsGroupRepository chartAccountsGroupRepository;

    public CreateChartAccountsGroupAdapter(ChartAccountsGroupRepository chartAccountsGroupRepository) {
        this.chartAccountsGroupRepository = chartAccountsGroupRepository;
    }

    @Override
    public void create(ChartAccountsGroup chartAccountsGroup) {
        var chartAccountsGroupEntity = ChartAccountsGroupEntityMapper.convertChartAccountsGroupToChartAccountsGroupEntity(chartAccountsGroup);
        chartAccountsGroupRepository.save(chartAccountsGroupEntity);
    }
}
