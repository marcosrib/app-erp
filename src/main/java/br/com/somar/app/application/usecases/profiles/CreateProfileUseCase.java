package br.com.somar.app.application.usecases.profiles;

import br.com.somar.app.application.domain.Profile;
import br.com.somar.app.application.ports.in.profiles.CreateProfileUseCasePort;
import br.com.somar.app.application.ports.out.profiles.CreateProfileAdapterPort;

public class CreateProfileUseCase implements CreateProfileUseCasePort {
  private final CreateProfileAdapterPort createProfileAdapterPort;
    public CreateProfileUseCase(CreateProfileAdapterPort createProfileAdapterPort) {
        this.createProfileAdapterPort = createProfileAdapterPort;
    }
    @Override
    public Profile create(Profile profile) {

        return this.createProfileAdapterPort.create(profile);
    }
}
