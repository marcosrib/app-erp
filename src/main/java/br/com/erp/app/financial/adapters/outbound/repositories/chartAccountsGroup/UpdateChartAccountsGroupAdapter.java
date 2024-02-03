package br.com.erp.app.financial.adapters.outbound.repositories.chartAccountsGroup;

import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.UpdateChartAccountsGroupAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateChartAccountsGroupAdapter implements UpdateChartAccountsGroupAdapterPort {
    private final ChartAccountsGroupRepository chartAccountsGroupRepository;

    public UpdateChartAccountsGroupAdapter(ChartAccountsGroupRepository chartAccountsGroupRepository) {
        this.chartAccountsGroupRepository = chartAccountsGroupRepository;
    }

    @Override
    public void update(ChartAccountsGroup chartAccountsGroup) {
        var chartAccountsGroupEntity = ChartAccountsGroupEntityMapper.convertChartAccountsGroupToChartAccountsGroupEntity(chartAccountsGroup);
        chartAccountsGroupRepository.save(chartAccountsGroupEntity);
    }
}
