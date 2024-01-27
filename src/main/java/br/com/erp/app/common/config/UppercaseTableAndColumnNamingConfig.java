package br.com.erp.app.common.config;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UppercaseTableAndColumnNamingConfig {

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new UpperCaseTableAndColumnNamingStrategy();
    }
}
