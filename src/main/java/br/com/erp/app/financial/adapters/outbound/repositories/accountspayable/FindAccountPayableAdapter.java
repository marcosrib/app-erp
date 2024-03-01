package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.AccountPayableEntity;
import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.ports.out.accountspayable.FindAccountPayableAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class FindAccountPayableAdapter implements FindAccountPayableAdapterPort {
  private  final AccountPayableRepository accountPayableRepository;

    public FindAccountPayableAdapter(AccountPayableRepository accountPayableRepository) {
        this.accountPayableRepository = accountPayableRepository;
    }

    @Override
    public AccountPayable findById(Long id) {
        var accountPayable  = accountPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("account.payable.not.found"));

        return AccountPayable.convertAccountPayableEntityToAccountPayable(accountPayable);
    }

    @Override
    public PageableFinancialDomain<AccountPayable> findAllPagination(AccountPayable filter, PageableFinancialRequestDomain pageable) {
        Specification<AccountPayableEntity> spec = Specification.where(null);

        if (!ObjectUtils.isEmpty(filter.status())) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("status"),  filter.status()));
        }
        Page<AccountPayableEntity> accountPayableEntityPage = accountPayableRepository.findAll(spec, PageRequest.of(pageable.page(), pageable.size(), Sort.by(Sort.Direction.DESC, "id")));
        var accountsPayable = AccountPayable.convertAccountPayableEntityListToAccountPayableList(accountPayableEntityPage.getContent());
        return PageableFinancialDomain
                .builder()
                .data(accountsPayable)
                .totalPages(accountPayableEntityPage.getTotalPages())
                .totalElements(accountPayableEntityPage.getTotalElements())
                .currentPage(accountPayableEntityPage.getNumber())
                .nextPage()
                .previousPage()
                .build();

    }
}
