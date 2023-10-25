package br.com.somar.app.users.application.core.domain;

import br.com.somar.app.users.adapters.outbound.repositories.entity.AbilityGroupEntity;

import java.util.List;


public class AbilityGroup {

    private Long id;
    private String name;
    private String code;
    private List<Ability> abilities;

    public AbilityGroup() {
    }
    public AbilityGroup(Long id) {
        this.id = id;
    }
    public AbilityGroup(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public AbilityGroup(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public AbilityGroup(String name, List<Ability> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static AbilityGroup convertAbilityGroupEntityIntoAbilityGroup(AbilityGroupEntity abilityGroupEntity) {
        return new AbilityGroup(abilityGroupEntity.getId(), abilityGroupEntity.getName(), abilityGroupEntity.getCode());
    }
}

