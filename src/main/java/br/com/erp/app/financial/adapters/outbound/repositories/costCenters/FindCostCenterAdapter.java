package br.com.erp.app.financial.adapters.outbound.repositories.costCenters;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.CostCenterEntity;
import br.com.erp.app.financial.application.core.domain.CostCenter;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.out.costcenters.FindCostCenterAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class FindCostCenterAdapter implements FindCostCenterAdapterPort {
    private final CostCenterRepository costCenterRepository;

    public FindCostCenterAdapter(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    @Override
    public PageableFinancialDomain<CostCenter> findAllPagination(String name, PageableFinancialRequestDomain pageable) {

        Specification<CostCenterEntity> spec = Specification.where(null);

        if (!ObjectUtils.isEmpty(name)) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("name"), "%" + name + "%"));
        }
        Page<CostCenterEntity> costCenterEntityPage = costCenterRepository.findAll(spec, PageRequest.of(pageable.page(), pageable.size(), Sort.by(Sort.Direction.DESC, "id")));
        var costCenters = CostCenter.convertPageCostCenterEntityToListCostCenter(costCenterEntityPage.getContent());
        return PageableFinancialDomain
                .builder()
                .data(costCenters)
                .totalPages(costCenterEntityPage.getTotalPages())
                .totalElements(costCenterEntityPage.getTotalElements())
                .currentPage(costCenterEntityPage.getNumber())
                .nextPage()
                .previousPage();
    }

    @Override
    public CostCenter findById(Integer id) {
        var costCenter = costCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cost.center.not.found"));
        return CostCenter.convertCostCenterEntityToCostCenter(costCenter);
    }

    @Override
    public List<CostCenter> findAllCostCenter() {
        var costCenterEntities = costCenterRepository.findAll();
        return CostCenter.convertPageCostCenterEntityToListCostCenter(costCenterEntities);
    }
}
