package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.responses.abilities.GroupAbilityResponse;
import br.com.somar.app.users.application.ports.in.abilities.CreateAbilityUseCasePort;
import br.com.somar.app.users.application.ports.in.abilities.FindAbilityUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {
    private final FindAbilityUseCasePort findAbilityUseCasePort;

    private final CreateAbilityUseCasePort createAbilityUseCasePort;

    public AbilityController(FindAbilityUseCasePort findAbilityUseCasePort, CreateAbilityUseCasePort createAbilityUseCasePort) {
        this.findAbilityUseCasePort = findAbilityUseCasePort;
        this.createAbilityUseCasePort = createAbilityUseCasePort;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbilityResponse> index() {
        var group = GroupAbilityResponse.fromDomain(findAbilityUseCasePort.findAllAbilities());
        return group;
    }
    @GetMapping("/{profileId}/profile")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbilityResponse> show(@PathVariable Long profileId) {
        var group = GroupAbilityResponse.fromDomain(findAbilityUseCasePort.findAbilityByProfileId(profileId));
        return group;
    }
}
