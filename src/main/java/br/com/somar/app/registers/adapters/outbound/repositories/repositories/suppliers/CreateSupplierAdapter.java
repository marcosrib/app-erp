package br.com.somar.app.registers.adapters.outbound.repositories.repositories.suppliers;

import br.com.somar.app.registers.application.core.domain.Supplier;
import br.com.somar.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierAdapter implements CreateSupplierAdapterPort {
    @Override
    public void create(Supplier supplier) {

    }
}
