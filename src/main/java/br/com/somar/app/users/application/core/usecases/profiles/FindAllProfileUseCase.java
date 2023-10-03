package br.com.somar.app.users.application.core.usecases.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.ports.in.profiles.FindAllProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.FindAllProfileAdapterPort;

import java.util.List;

public class FindAllProfileUseCase implements FindAllProfileUseCasePort {

    private  final FindAllProfileAdapterPort findAllProfileAdapterPort;

    public FindAllProfileUseCase(FindAllProfileAdapterPort findAllProfileAdapterPort) {
        this.findAllProfileAdapterPort = findAllProfileAdapterPort;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return findAllProfileAdapterPort.getAllProfiles();
    }
}
