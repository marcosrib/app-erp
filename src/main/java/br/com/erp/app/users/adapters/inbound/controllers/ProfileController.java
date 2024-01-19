package br.com.erp.app.users.adapters.inbound.controllers;

import br.com.erp.app.users.adapters.inbound.controllers.requests.ProfileWithAbilitiesRequest;
import br.com.erp.app.users.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import br.com.erp.app.users.adapters.inbound.controllers.swagger.api.PerfilApi;
import br.com.erp.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.erp.app.users.application.ports.in.profiles.UpdateProfileUseCasePort;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/profile")
public class ProfileController implements PerfilApi {
    private final CreateProfileUseCasePort createProfileUseCasePort;
    private final FindProfileAdapterPort findProfileAdapterPort;

    private final UpdateProfileUseCasePort updateProfileUseCasePort;

    public ProfileController(CreateProfileUseCasePort createProfileUseCasePort,
                             FindProfileAdapterPort findProfileAdapterPort,
                             UpdateProfileUseCasePort updateProfileUseCasePort) {
        this.createProfileUseCasePort = createProfileUseCasePort;
        this.findProfileAdapterPort = findProfileAdapterPort;
        this.updateProfileUseCasePort = updateProfileUseCasePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProfileWithAbilitiesRequest profileRequest) {
        createProfileUseCasePort.create(profileRequest.toProfileDomain());
    }

    @PutMapping("/{profileId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody ProfileWithAbilitiesRequest profileRequest, @PathVariable Long profileId) {
        updateProfileUseCasePort.update(profileRequest.toProfileDomain(), profileId);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Set<ProfileResponse> index() {
        return ProfileResponse.fromDomainToList(findProfileAdapterPort.getAllProfiles());
    }

    @GetMapping("/{profileId}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileResponse show(@PathVariable Long profileId) {
        return ProfileResponse.fromDomain(findProfileAdapterPort.findProfileBydId(profileId));
    }
}