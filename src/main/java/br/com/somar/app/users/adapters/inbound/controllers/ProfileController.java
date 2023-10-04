package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.requests.CreateProfileRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.profiles.ProfileAbilitiesResponse;
import br.com.somar.app.users.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.somar.app.users.application.ports.in.profiles.FindAllProfileUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final CreateProfileUseCasePort createProfileUseCasePort;
    private final FindAllProfileUseCasePort findAllProfileUseCasePort;
    public ProfileController(CreateProfileUseCasePort createProfileUseCasePort, FindAllProfileUseCasePort findAllProfileUseCasePort) {
        this.createProfileUseCasePort = createProfileUseCasePort;
        this.findAllProfileUseCasePort = findAllProfileUseCasePort;
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileAbilitiesResponse create(@RequestBody CreateProfileRequest createProfileRequest) {
        return ProfileAbilitiesResponse.fromDomain(createProfileUseCasePort.create(createProfileRequest.toProfileDomain()));
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileResponse> show() {
     return ProfileResponse.fromDomainToList(findAllProfileUseCasePort.getAllProfiles());
    }

}