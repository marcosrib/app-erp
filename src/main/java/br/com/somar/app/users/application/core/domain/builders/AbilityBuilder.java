package br.com.somar.app.users.application.core.domain.builders;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.core.domain.AbilityCategory;
import br.com.somar.app.users.application.core.domain.AbilityGroup;

public class AbilityBuilder {
    private Long id;
    private String name;
    private String groupName;
    private AbilityGroup abilityGroup;
    private AbilityCategory abilityCategory;
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

    public AbilityBuilder groupAbilityId(AbilityGroup abilityGroup) {
        this.abilityGroup = abilityGroup;
        return this;
    }

    public AbilityBuilder categoryAbilityId(AbilityCategory abilityCategory) {
        this.abilityCategory = abilityCategory;
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
        ability.setAbilityGroup(abilityGroup);
        ability.setAbilityCategory(abilityCategory);
        ability.setGroupName(groupName);
        return ability;
    }
}
