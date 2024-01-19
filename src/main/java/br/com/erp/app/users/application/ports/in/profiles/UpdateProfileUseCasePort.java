package br.com.erp.app.users.application.ports.in.profiles;

import br.com.erp.app.users.application.core.domain.Profile;

public interface UpdateProfileUseCasePort {
    void update(Profile profile, Long id);
}
