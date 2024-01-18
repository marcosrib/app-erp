package br.com.somar.app.registers.config.beans;

import br.com.somar.app.registers.application.core.usecases.suppliers.CreateSupplierUseCase;
import br.com.somar.app.registers.application.ports.in.suppliers.CreateSupplierUseCasePort;
import br.com.somar.app.registers.application.ports.out.suppliers.CreateSupplierAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierBeanConfig {
    @Bean
    public CreateSupplierUseCasePort createSupplierUseCasePort(CreateSupplierAdapterPort createSupplierAdapterPort) {
        return new CreateSupplierUseCase(createSupplierAdapterPort);
    }
}
