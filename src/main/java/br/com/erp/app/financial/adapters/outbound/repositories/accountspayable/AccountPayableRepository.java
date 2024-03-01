package br.com.erp.app.financial.adapters.outbound.repositories.accountspayable;

import br.com.erp.app.financial.adapters.outbound.repositories.entities.AccountPayableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountPayableRepository extends JpaRepository<AccountPayableEntity, Long> {
    Page<AccountPayableEntity> findAll(Specification<AccountPayableEntity> spec, Pageable page);
}
