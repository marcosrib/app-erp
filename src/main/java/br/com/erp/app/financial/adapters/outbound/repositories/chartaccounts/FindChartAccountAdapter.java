package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.ChartAccountEntity;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.out.chartaccounts.FindChartAccountAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class FindChartAccountAdapter implements FindChartAccountAdapterPort {

    private final ChartAccountRepository chartAccountRepository;

    public FindChartAccountAdapter(ChartAccountRepository chartAccountRepository) {
        this.chartAccountRepository = chartAccountRepository;
    }

    @Override
    public ChartAccount findChartAccountById(Integer id) {
        var chartAccountEntity = chartAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cart.accounts.not.found"));
        return ChartAccount.convertChartAccountEntityToChartAccount(chartAccountEntity);
    }

    @Override
    public PageableFinancialDomain<ChartAccount> findAllPagination(String name, PageableFinancialRequestDomain pageable) {
        Specification<ChartAccountEntity> spec = Specification.where(null);

        if (!ObjectUtils.isEmpty(name)) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("name"), "%" + name + "%"));
        }
        Page<ChartAccountEntity> chartAccountEntityPage = chartAccountRepository.findAll(spec, PageRequest.of(pageable.page(), pageable.size(), Sort.by(Sort.Direction.DESC, "id")));
        var chartAccounts = ChartAccount.convertChartAccountEntityListToChartAccountList(chartAccountEntityPage.getContent());
        return PageableFinancialDomain
                .builder()
                .data(chartAccounts)
                .totalPages(chartAccountEntityPage.getTotalPages())
                .totalElements(chartAccountEntityPage.getTotalElements())
                .currentPage(chartAccountEntityPage.getNumber())
                .nextPage()
                .previousPage()
                .build();

    }

    @Override
    public List<ChartAccount> findAllChartAccount() {
        var chartAccountEntities = chartAccountRepository.findAll();
        return ChartAccount.convertChartAccountEntityListToChartAccountList(chartAccountEntities);
    }
}
