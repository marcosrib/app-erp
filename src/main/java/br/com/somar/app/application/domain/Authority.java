package br.com.somar.app.application.domain;

public class Authority {
    private String group;
    private String ability;
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
