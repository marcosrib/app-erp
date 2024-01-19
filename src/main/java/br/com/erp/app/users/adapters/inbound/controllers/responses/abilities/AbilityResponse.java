package br.com.erp.app.users.adapters.inbound.controllers.responses.abilities;

import lombok.Getter;

@Getter
public class AbilityResponse {
    private final Long id;
    private final String name;
    private final boolean hasAbilityProfile;

    public AbilityResponse(Long id, String name, boolean hasAbilityProfile) {
        this.id = id;
        this.name = name;
        this.hasAbilityProfile = hasAbilityProfile;
    }

}
