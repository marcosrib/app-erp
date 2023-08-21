package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.requests.CreateProfileRequest;
import br.com.somar.app.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.somar.app.adapters.outbound.repositories.abilities.AbilityRepository;
import br.com.somar.app.application.domain.Ability;
import br.com.somar.app.application.domain.GroupAbility;
import br.com.somar.app.adapters.outbound.repositories.entity.AbilityEntity;
import br.com.somar.app.adapters.outbound.repositories.profiles.ProfileRepository;
import br.com.somar.app.application.ports.in.profiles.CreateProfileUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private AbilityRepository abilityRepository;

    @Autowired
    private ProfileRepository profileRepository;
    private final CreateProfileUseCasePort createProfileUseCasePort;

    public ProfileController(CreateProfileUseCasePort createProfileUseCasePort) {
        this.createProfileUseCasePort = createProfileUseCasePort;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse create(@RequestBody CreateProfileRequest createProfileRequest) {
        return ProfileResponse.fromDomain(createProfileUseCasePort.create(createProfileRequest.toProfileDomain()));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbility> show() {
     return null;


    }


}