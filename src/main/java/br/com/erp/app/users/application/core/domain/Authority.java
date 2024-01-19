package br.com.erp.app.users.application.core.domain;

public class Authority {
    private final String group;
    private final String ability;

    public Authority(String group, String ability) {
        this.group = group;
        this.ability = ability;
    }

    public String getGroup() {
        return group;
    }

    public String getAbility() {
        return ability;
    }
}
