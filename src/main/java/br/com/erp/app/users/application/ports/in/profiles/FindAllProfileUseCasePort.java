package br.com.erp.app.users.application.ports.in.profiles;

import br.com.erp.app.users.application.core.domain.Profile;

import java.util.Set;

public interface FindAllProfileUseCasePort {
    Set<Profile> getAllProfiles();
}
