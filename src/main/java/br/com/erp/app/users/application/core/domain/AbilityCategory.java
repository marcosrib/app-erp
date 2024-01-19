package br.com.erp.app.users.application.core.domain;

import br.com.erp.app.users.adapters.outbound.repositories.entity.AbilityCategoryEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AbilityCategory {
    private Long id;
    private String code;
    private String name;

    public AbilityCategory() {
    }

    public AbilityCategory(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public AbilityCategory(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public static Set<AbilityCategory> convertListAbilityCategoryEntityIntoListAbilityCategory(List<AbilityCategoryEntity> abilityCategoryEntities) {
        return abilityCategoryEntities.stream().map(abilityCategoryEntity ->
                        new AbilityCategory(
                                abilityCategoryEntity.getId(),
                                abilityCategoryEntity.getName(),
                                abilityCategoryEntity.getCode()))
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
