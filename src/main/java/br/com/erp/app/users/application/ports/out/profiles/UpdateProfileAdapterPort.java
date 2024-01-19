package br.com.erp.app.users.application.ports.out.profiles;

import br.com.erp.app.users.application.core.domain.Profile;

public interface UpdateProfileAdapterPort {
    void update(Profile profile);
}
