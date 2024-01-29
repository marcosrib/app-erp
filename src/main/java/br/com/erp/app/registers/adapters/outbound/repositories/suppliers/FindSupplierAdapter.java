package br.com.erp.app.registers.adapters.outbound.repositories.suppliers;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.registers.adapters.outbound.repositories.entities.SupplierEntity;
import br.com.erp.app.registers.application.core.domain.PageableRegisterDomain;
import br.com.erp.app.registers.application.core.domain.PageableRequestRegisterDomain;
import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.ports.out.suppliers.FindSupplierAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class FindSupplierAdapter implements FindSupplierAdapterPort {
    private final SupplierRepository supplierRepository;

    public FindSupplierAdapter(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Supplier findSupplierById(Long id) {
        var supplierEntity = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("supplier.not.exist"));
        return Supplier.convertsupplierEntityToSupplier(supplierEntity);
    }

    @Override
    public PageableRegisterDomain<Supplier> findSuppliersWithPagination(Supplier filter, PageableRequestRegisterDomain pageable) {
        Specification<Supplier> spec = Specification.where(null);

        if (!ObjectUtils.isEmpty(filter.getEmail())) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("email"), "%" + filter.getEmail() + "%"));
        }
        Page<SupplierEntity> supplierEntityPage = supplierRepository.findAll(spec, PageRequest.of(pageable.page(), pageable.size(), Sort.by(Sort.Direction.DESC, "id")));
        return  PageableRegisterDomain.builder()
                .data(supplierEntityPage.getContent())
                .totalPages(supplierEntityPage.getTotalPages())
                .totalElements(supplierEntityPage.getTotalElements())
                .currentPage(supplierEntityPage.getNumber())
                .nextPage()
                .previousPage();
    }
}
