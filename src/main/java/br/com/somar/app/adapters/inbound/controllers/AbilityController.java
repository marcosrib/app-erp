package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.application.domain.GroupAbility;
import br.com.somar.app.application.ports.in.abilities.FindAbilityUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {

    @Autowired
    private FindAbilityUseCasePort findAbilityUseCasePort;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbility> show() {
        return findAbilityUseCasePort.findAbilityByProfileId(1L);
    }
}
