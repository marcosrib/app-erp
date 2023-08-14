package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.requests.CreateProfileRequest;
import br.com.somar.app.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.somar.app.application.ports.in.profiles.CreateProfileUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final CreateProfileUseCasePort createProfileUseCasePort;

    public ProfileController(CreateProfileUseCasePort createProfileUseCasePort) {
        this.createProfileUseCasePort = createProfileUseCasePort;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse create(@RequestBody CreateProfileRequest createProfileRequest) {
        return ProfileResponse.fromDomain(createProfileUseCasePort.create(createProfileRequest.toProfileDomain()));
    }
}