package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.responses.abilities.GroupAbilityResponse;
import br.com.somar.app.users.application.ports.in.abilities.FindAbilityUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {
    @Autowired
    private FindAbilityUseCasePort findAbilityUseCasePort;
    @GetMapping("/{profileId}/profile")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbilityResponse> show(@PathVariable Long profileId) {
        var group = GroupAbilityResponse.fromDomain(findAbilityUseCasePort.findAbilityByProfileId(profileId));
        return group;
    }
}
