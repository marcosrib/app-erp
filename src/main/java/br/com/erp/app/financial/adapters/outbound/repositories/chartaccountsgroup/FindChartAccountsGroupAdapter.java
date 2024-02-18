package br.com.erp.app.financial.adapters.outbound.repositories.chartaccountsgroup;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.FindChartAccountsGroupAdapterPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindChartAccountsGroupAdapter implements FindChartAccountsGroupAdapterPort {

    private final ChartAccountsGroupRepository chartAccountsGroupRepository;

    public FindChartAccountsGroupAdapter(ChartAccountsGroupRepository chartAccountsGroupRepository) {
        this.chartAccountsGroupRepository = chartAccountsGroupRepository;
    }

    @Override
    public ChartAccountsGroup findById(Integer id) {
        var chartAccountsGroupEntity = chartAccountsGroupRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("cart.accounts.group.not.found"));
        var chartAccountsGroup = ChartAccountsGroup.convertChartAccountsGroupEntityToChartAccountsGroup(chartAccountsGroupEntity);
        return chartAccountsGroup;
    }

    @Override
    public List<ChartAccountsGroup> findAll() {
        var chartAccountsGroupEntities = chartAccountsGroupRepository.findAll();
        return ChartAccountsGroup.convertChartAccountsGroupEntityListToChartAccountsGroupList(chartAccountsGroupEntities);
    }
}
