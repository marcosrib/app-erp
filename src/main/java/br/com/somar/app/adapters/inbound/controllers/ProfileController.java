package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.requests.CreateProfileRequest;
import br.com.somar.app.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.adapters.outbound.repositories.profiles.ProfileRepository;
import br.com.somar.app.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.application.ports.in.profiles.CreateProfileUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private UserRepository profileRepository;
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
    public List<UserEntity> get() {

        return profileRepository.findAll();
    }
}