package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.responses.abilities.GroupAbilityResponse;
import br.com.somar.app.application.domain.GroupAbility;
import br.com.somar.app.application.ports.in.abilities.FindAbilityUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {
    @Autowired
    private FindAbilityUseCasePort findAbilityUseCasePort;
    @GetMapping("/{id}/profile")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbilityResponse> show(@PathVariable Long id) {
        var group = GroupAbilityResponse.fromDomain(findAbilityUseCasePort.findAbilityByProfileId(id));
        return group;
    }
}
