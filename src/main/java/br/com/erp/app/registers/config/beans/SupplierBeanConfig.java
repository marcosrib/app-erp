package br.com.erp.app.registers.config.beans;

import br.com.erp.app.registers.application.core.usecases.suppliers.CreateSupplierUseCase;
import br.com.erp.app.registers.application.core.usecases.suppliers.FindSupplierUseCase;
import br.com.erp.app.registers.application.core.usecases.suppliers.UpdateSupplierUseCase;
import br.com.erp.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.in.suppliers.FindSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.in.suppliers.UpdateSupplierUseCasePort;
import br.com.erp.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;
import br.com.erp.app.registers.application.ports.out.suppliers.FindSupplierAdapterPort;
import br.com.erp.app.registers.application.ports.out.suppliers.UpdateSupplierAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierBeanConfig {
    @Bean
    public CreateSupplierUseCasePort createSupplierUseCasePort(CreateSupplierAdapterPort createSupplierAdapterPort) {
        return new CreateSupplierUseCase(createSupplierAdapterPort);
    }
    @Bean
    public UpdateSupplierUseCasePort updateSupplierUseCasePort(UpdateSupplierAdapterPort updateSupplierAdapterPort, FindSupplierAdapterPort findSupplierAdapterPort) {
        return new UpdateSupplierUseCase(updateSupplierAdapterPort, findSupplierAdapterPort);
    }

    @Bean
    public FindSupplierUseCasePort findSupplierAdapterPort(FindSupplierAdapterPort findSupplierAdapterPort) {
        return new FindSupplierUseCase(findSupplierAdapterPort);
    }


}
