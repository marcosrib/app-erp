package br.com.erp.app.users.adapters.outbound.fileproperties;

import java.util.List;

public class GroupFileProperties {
    private String name;
    private String code;
    private List<AbilityFileProperties> abilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AbilityFileProperties> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityFileProperties> abilities) {
        this.abilities = abilities;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}