package br.com.somar.app.users.adapters.inbound.controllers.responses.profiles;

import lombok.Getter;

@Getter
public class ProfileResponse {
    private Long id;
    private String name;

    public ProfileResponse() {
    }
    public ProfileResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
