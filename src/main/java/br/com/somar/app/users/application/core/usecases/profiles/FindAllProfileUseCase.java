package br.com.somar.app.users.application.core.usecases.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.ports.in.profiles.FindAllProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;

import java.util.List;

public class FindAllProfileUseCase implements FindAllProfileUseCasePort {

    private  final FindProfileAdapterPort findProfileAdapterPort;

    public FindAllProfileUseCase(FindProfileAdapterPort findProfileAdapterPort) {
        this.findProfileAdapterPort = findProfileAdapterPort;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return findProfileAdapterPort.getAllProfiles();
    }
}
