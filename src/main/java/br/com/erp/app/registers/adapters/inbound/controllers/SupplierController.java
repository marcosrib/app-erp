package br.com.erp.app.registers.adapters.inbound.controllers;

import br.com.erp.app.registers.adapters.inbound.controllers.requests.SupplierRequest;
import br.com.erp.app.registers.adapters.inbound.controllers.swagger.api.SupplierApi;
import br.com.erp.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.in.suppliers.UpdateSupplierUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController implements SupplierApi {

    private final CreateSupplierUseCasePort createSupplierUseCasePort;
    private final UpdateSupplierUseCasePort updateSupplierUseCasePort;
    public SupplierController(CreateSupplierUseCasePort createSupplierUseCasePort, UpdateSupplierUseCasePort updateSupplierUseCasePort) {
        this.createSupplierUseCasePort = createSupplierUseCasePort;
        this.updateSupplierUseCasePort = updateSupplierUseCasePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SupplierRequest supplierRequest) {
        createSupplierUseCasePort.create(supplierRequest.toSupplierDomain());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody SupplierRequest supplierRequest, @PathVariable Long id) {
        updateSupplierUseCasePort.update(supplierRequest.toSupplierDomain(),id);
    }
}
