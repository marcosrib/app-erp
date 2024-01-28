package br.com.erp.app.registers.adapters.inbound.controllers;

import br.com.erp.app.registers.adapters.inbound.controllers.requests.SupplierFilterRequest;
import br.com.erp.app.registers.adapters.inbound.controllers.requests.SupplierRequest;
import br.com.erp.app.registers.adapters.inbound.controllers.responses.PageRegisterResponse;
import br.com.erp.app.registers.adapters.inbound.controllers.responses.SupplierResponse;
import br.com.erp.app.registers.adapters.inbound.controllers.swagger.api.SupplierApi;
import br.com.erp.app.registers.application.core.domain.PageableRequestRegisterDomain;
import br.com.erp.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.in.suppliers.FindSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.in.suppliers.UpdateSupplierUseCasePort;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController implements SupplierApi {
    private final CreateSupplierUseCasePort createSupplierUseCasePort;
    private final UpdateSupplierUseCasePort updateSupplierUseCasePort;
    private final FindSupplierUseCasePort findSupplierUseCasePort;

    public SupplierController(CreateSupplierUseCasePort createSupplierUseCasePort, UpdateSupplierUseCasePort updateSupplierUseCasePort, FindSupplierUseCasePort findSupplierUseCasePort) {
        this.createSupplierUseCasePort = createSupplierUseCasePort;
        this.updateSupplierUseCasePort = updateSupplierUseCasePort;
        this.findSupplierUseCasePort = findSupplierUseCasePort;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageRegisterResponse index(SupplierFilterRequest filter, Pageable pageable) {
        var pageableRequest = new PageableRequestRegisterDomain(pageable.getPageNumber(), pageable.getPageSize());
        var supplierPage = findSupplierUseCasePort.getSupplierWithPaginationAndFilter(filter.toSupplierDomain(), pageableRequest);
        var suppliersResponse = SupplierResponse.fromDomainToList(supplierPage.getData());
        return PageRegisterResponse
                .builder()
                .data(suppliersResponse)
                .previousPage(supplierPage.getPreviousPage())
                .totalElements(supplierPage.getTotalElements())
                .totalPages(supplierPage.getTotalPages())
                .nextPage(supplierPage.getNextPage())
                .currentPage(supplierPage.getCurrentPage());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SupplierRequest supplierRequest) {
        createSupplierUseCasePort.create(supplierRequest.toSupplierDomain());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody SupplierRequest supplierRequest, @PathVariable Long id) {
        updateSupplierUseCasePort.update(supplierRequest.toSupplierDomain(), id);
    }
}
