package br.com.somar.app.users.application.core.usecases.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.ports.in.profiles.UpdateProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.UpdateProfileAdapterPort;

public class UpdateProfileUseCase implements UpdateProfileUseCasePort {
    private final UpdateProfileAdapterPort updateProfileAdapterPort;
    private  final FindProfileAdapterPort findProfileAdapterPort;
    public UpdateProfileUseCase(UpdateProfileAdapterPort updateProfileAdapterPort, FindProfileAdapterPort findProfileAdapterPort) {
        this.updateProfileAdapterPort = updateProfileAdapterPort;
        this.findProfileAdapterPort = findProfileAdapterPort;
    }
    @Override
    public void update(Profile profile, Long id) {
        Profile existingProfile = findProfileAdapterPort.findProfileBydId(id);
        existingProfile.setName(profile.getName());
        existingProfile.setAbilities(profile.getAbilities());
        updateProfileAdapterPort.update(existingProfile);
    }
}
