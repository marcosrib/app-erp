package br.com.erp.app.users.application.ports.in.profiles;

import br.com.erp.app.users.application.core.domain.Profile;

public interface CreateProfileUseCasePort {
    void create(Profile profile);
}
