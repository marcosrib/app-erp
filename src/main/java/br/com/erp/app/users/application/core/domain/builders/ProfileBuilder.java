package br.com.erp.app.users.application.core.domain.builders;

import br.com.erp.app.users.application.core.domain.Ability;
import br.com.erp.app.users.application.core.domain.Profile;

import java.util.Set;

public class ProfileBuilder {
    private Long id;
    private String name;

    private String description;
    private Set<Ability> abilities;

    public ProfileBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProfileBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProfileBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProfileBuilder abilities(Set<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    public Profile build() {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setName(name);
        profile.setDescription(description);
        profile.setAbilities(abilities);
        return profile;
    }
}
