package br.com.somar.app.users.adapters.inbound.controllers.responses.abilities;

import lombok.Getter;

@Getter
public class AbilityResponse {
    private Long id;
    private String name;
    private boolean hasAbilityProfile;
    public AbilityResponse(Long id, String name, boolean hasAbilityProfile) {
        this.id = id;
        this.name = name;
        this.hasAbilityProfile = hasAbilityProfile;
    }

}
