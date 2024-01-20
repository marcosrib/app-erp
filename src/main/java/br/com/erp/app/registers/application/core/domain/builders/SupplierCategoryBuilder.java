package br.com.erp.app.registers.application.core.domain.builders;

import br.com.erp.app.registers.application.core.domain.SupplierCategory;

public class SupplierCategoryBuilder {
    private Long id;
    private String name;

    public SupplierCategoryBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public SupplierCategoryBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SupplierCategory build() {
        SupplierCategory supplierCategory = new SupplierCategory();
        supplierCategory.setId(id);
        supplierCategory.setName(name);
        return supplierCategory;
    }

}
