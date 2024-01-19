package br.com.erp.app.registers.adapters.inbound.controllers;

import br.com.erp.app.registers.adapters.inbound.controllers.requests.SupplierRequest;
import br.com.erp.app.registers.adapters.inbound.controllers.swagger.api.SupplierApi;
import br.com.erp.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController implements SupplierApi {

    private final CreateSupplierUseCasePort createSupplierUseCasePort;

    public SupplierController(CreateSupplierUseCasePort createSupplierUseCasePort) {
        this.createSupplierUseCasePort = createSupplierUseCasePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SupplierRequest supplierRequest) {
        createSupplierUseCasePort.create(supplierRequest.toSupplierDomain());
    }
}
