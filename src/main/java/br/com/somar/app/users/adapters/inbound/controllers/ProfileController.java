package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.requests.ProfileRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.somar.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.somar.app.users.application.ports.in.profiles.UpdateProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final CreateProfileUseCasePort createProfileUseCasePort;
    private final FindProfileAdapterPort findProfileAdapterPort;

    private  final UpdateProfileUseCasePort updateProfileUseCasePort;

    public ProfileController(CreateProfileUseCasePort createProfileUseCasePort,
                             FindProfileAdapterPort findProfileAdapterPort,
                             UpdateProfileUseCasePort updateProfileUseCasePort) {
        this.createProfileUseCasePort = createProfileUseCasePort;
        this.findProfileAdapterPort = findProfileAdapterPort;
        this.updateProfileUseCasePort = updateProfileUseCasePort;
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProfileRequest profileRequest) {
        createProfileUseCasePort.create(profileRequest.toProfileDomain());
    }
    @PutMapping("/{profileId}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ProfileRequest profileRequest, @PathVariable Long profileId) {
        updateProfileUseCasePort.update(profileRequest.toProfileDomain(), profileId);
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileResponse> show() {
     return ProfileResponse.fromDomainToList(findProfileAdapterPort.getAllProfiles());
    }

}