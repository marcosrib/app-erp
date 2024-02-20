package br.com.erp.app.financial.adapters.outbound.repositories.chartaccountsgroup;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountsGroupEntity;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import br.com.erp.app.financial.application.core.domain.ChartAccountsGroup;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.out.chartAccountsGroup.FindChartAccountsGroupAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    @Override
    public PageableFinancialDomain<ChartAccountsGroup> findAllPagination(String name, PageableFinancialRequestDomain pageable) {

        Specification<ChartAccountsGroupEntity> spec = Specification.where(null);

        if (!ObjectUtils.isEmpty(name)) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("name"), "%" + name + "%"));
        }
        Page<ChartAccountsGroupEntity> chartAccountsGroupEntityPage = chartAccountsGroupRepository.findAll(spec, PageRequest.of(pageable.page(), pageable.size(), Sort.by(Sort.Direction.DESC, "id")));
        var chartAccountsGroup = ChartAccountsGroup.convertChartAccountsGroupEntityListToChartAccountsGroupList(chartAccountsGroupEntityPage.getContent());
        return PageableFinancialDomain
                .builder()
                .data(chartAccountsGroup)
                .totalPages(chartAccountsGroupEntityPage.getTotalPages())
                .totalElements(chartAccountsGroupEntityPage.getTotalElements())
                .currentPage(chartAccountsGroupEntityPage.getNumber())
                .nextPage()
                .previousPage()
                .build();
    }
}
