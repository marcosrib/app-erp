package br.com.somar.app.application.ports.out.profiles;

import br.com.somar.app.application.domain.Profile;

public interface CreateProfileAdapterPort {
    Profile create(Profile profile);
}
