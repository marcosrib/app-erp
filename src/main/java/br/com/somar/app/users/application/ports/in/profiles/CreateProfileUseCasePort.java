package br.com.somar.app.users.application.ports.in.profiles;

import br.com.somar.app.users.application.core.domain.Profile;

public interface CreateProfileUseCasePort {
    Profile create(Profile profile);
}
