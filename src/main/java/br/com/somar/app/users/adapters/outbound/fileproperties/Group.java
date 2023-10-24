package br.com.somar.app.users.adapters.outbound.fileproperties;

import java.util.List;

public class Group {
    private String name;
    private List<Ability> abilities;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}