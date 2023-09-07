package br.com.somar.app.users.application.ports.out.profiles;

import br.com.somar.app.users.application.core.domain.Profile;

public interface CreateProfileAdapterPort {
    Profile create(Profile profile);
}
