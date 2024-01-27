package br.com.erp.app.common.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class UpperCaseTableAndColumnNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier("\"" +identifier.getText().toUpperCase() + "\"");
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier("\"" +identifier.getText().toUpperCase()+"\"");
    }
}
