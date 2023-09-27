package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.requests.CreateProfileRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.profiles.ProfileAbilitiesResponse;
import br.com.somar.app.users.adapters.outbound.repositories.abilities.AbilityRepository;
import br.com.somar.app.users.application.core.domain.GroupAbility;
import br.com.somar.app.users.adapters.outbound.repositories.profiles.ProfileRepository;
import br.com.somar.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ProfileAbilitiesResponse create(@RequestBody CreateProfileRequest createProfileRequest) {
        return ProfileAbilitiesResponse.fromDomain(createProfileUseCasePort.create(createProfileRequest.toProfileDomain()));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupAbility> show() {
     return null;


    }


}