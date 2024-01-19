package br.com.erp.app.users.adapters.inbound.controllers.responses.abilities;

import br.com.erp.app.users.application.core.domain.Authority;
import lombok.Data;

@Data
public class AuthorityResponse {
    private String group;
    private String ability;

    public AuthorityResponse(Authority authority) {
        this.group = authority.getGroup();
        this.ability = authority.getAbility();
    }
}
