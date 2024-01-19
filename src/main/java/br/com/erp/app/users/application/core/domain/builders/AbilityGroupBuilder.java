package br.com.erp.app.users.application.core.domain.builders;

import br.com.erp.app.users.application.core.domain.Ability;

import java.util.List;

public class AbilityGroupBuilder {
    private Long id;
    private String name;
    private String code;
    private List<Ability> abilities;

    public AbilityGroupBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AbilityGroupBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AbilityGroupBuilder code(String code) {
        this.code = code;
        return this;
    }

    public Ability build() {
        Ability ability = new Ability();
        ability.setId(id);
        ability.setName(name);
        return ability;
    }
}
