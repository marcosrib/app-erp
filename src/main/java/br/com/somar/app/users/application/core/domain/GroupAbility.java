package br.com.somar.app.users.application.core.domain;

import java.util.List;


public class GroupAbility {
   private String name;
   private List<Ability> abilities;

    public GroupAbility(String name, List<Ability> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}

