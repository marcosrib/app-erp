package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.adapters.outbound.repositories.entities.AccountPayableEntity;
import br.com.erp.app.financial.application.core.domain.AccountPayable;
import br.com.erp.app.financial.application.core.domain.PageableFinancialDomain;
import br.com.erp.app.financial.application.core.domain.PageableFinancialRequestDomain;
import br.com.erp.app.financial.application.core.domain.enums.AccountPayableStatusEnum;
import br.com.erp.app.financial.application.core.domain.filters.AccountPayableFilter;
import br.com.erp.app.financial.application.ports.out.accountspayable.FindAccountPayableAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FindAccountPayableAdapter implements FindAccountPayableAdapterPort {
    private final AccountPayableRepository accountPayableRepository;

    public FindAccountPayableAdapter(AccountPayableRepository accountPayableRepository) {
        this.accountPayableRepository = accountPayableRepository;
    }

    @Override
    public AccountPayable findById(Long id) {
        var accountPayable = accountPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("account.payable.not.found"));

        return AccountPayable.convertAccountPayableEntityToAccountPayable(accountPayable);
    }

    @Override
    public PageableFinancialDomain<AccountPayable> findAllPagination(AccountPayableFilter filter, PageableFinancialRequestDomain pageable) {
        Specification<AccountPayableEntity> spec = filters(filter);

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

    private Specification<AccountPayableEntity> filters(AccountPayableFilter filter) {
        return Specification.<AccountPayableEntity>where(null)
                .and(statusIs(filter.status()))
                .and(costCenterIdEquals(filter.costCenterId()))
                .and(dateDueBetween(filter.dateDueInitial(), filter.dateDueFinal()));
    }

    private Specification<AccountPayableEntity> statusIs(AccountPayableStatusEnum status) {
        if (status.equals(AccountPayableStatusEnum.NONE)) {
            return (root, query, builder) ->
                    builder.in(root.get("status"))
                            .value(AccountPayableStatusEnum.PAID)
                            .value(AccountPayableStatusEnum.PENDING);
        }

        return (root, query, builder) ->
                builder.equal(root.get("status"), status);

    }

    private Specification<AccountPayableEntity> costCenterIdEquals(Integer costCenterId) {
        if (costCenterId == null) {
            return null;
        }
        return (root, query, builder) ->
                builder.equal(root.get("costCenterEntity").get("id"), costCenterId);
    }

    private Specification<AccountPayableEntity> dateDueBetween(LocalDate dateDueInitial, LocalDate dateDueFinal) {
        if (dateDueInitial == null || dateDueFinal == null) {
            return null;
        }
        return (root, query, builder) ->
                builder.between(root.get("dueDate"), dateDueInitial, dateDueFinal);
    }

}

