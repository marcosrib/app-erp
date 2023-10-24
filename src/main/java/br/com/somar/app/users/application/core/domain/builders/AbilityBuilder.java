package br.com.somar.app.users.application.core.domain.builders;

import br.com.somar.app.users.application.core.domain.Ability;

public class AbilityBuilder {
    private Long id;
    private String name;
    private String groupName;
    private Long groupAbilityId;
    private Long categoryAbilityId;
    private boolean hasAbilityProfile;


    public AbilityBuilder id(Long id) {
        this.id = id;
        return this;
    }
    public AbilityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AbilityBuilder groupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public AbilityBuilder groupAbilityId(Long groupAbilityId) {
        this.groupAbilityId = groupAbilityId;
        return this;
    }

    public AbilityBuilder categoryAbilityId(Long categoryAbilityId) {
        this.categoryAbilityId = categoryAbilityId;
        return this;
    }

    public AbilityBuilder hasAbilityProfile(boolean hasAbilityProfile) {
        this.hasAbilityProfile = hasAbilityProfile;
        return this;
    }

    public Ability build() {
        Ability ability = new Ability();
        ability.setId(id);
        ability.setName(name);
        ability.setCategoryAbilityId(categoryAbilityId);
        ability.setGroupAbilityId(groupAbilityId);
        ability.setGroupName(groupName);
        return ability;
    }
}
