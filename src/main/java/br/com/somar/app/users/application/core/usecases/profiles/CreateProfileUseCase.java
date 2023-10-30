package br.com.somar.app.users.application.core.usecases.profiles;

import br.com.somar.app.users.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.CreateProfileAdapterPort;
import br.com.somar.app.users.application.core.domain.Profile;

public class CreateProfileUseCase implements CreateProfileUseCasePort {
  private final CreateProfileAdapterPort createProfileAdapterPort;
    public CreateProfileUseCase(CreateProfileAdapterPort createProfileAdapterPort) {
        this.createProfileAdapterPort = createProfileAdapterPort;
    }
    @Override
    public void create(Profile profile) {
        createProfileAdapterPort.create(profile);
    }
}
