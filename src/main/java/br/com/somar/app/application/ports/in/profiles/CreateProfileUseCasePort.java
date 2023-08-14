package br.com.somar.app.application.ports.in.profiles;

import br.com.somar.app.application.domain.Profile;

public interface CreateProfileUseCasePort {
    Profile create(Profile profile);
}
