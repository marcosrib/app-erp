package br.com.erp.app.users.application.ports.out.profiles;

import br.com.erp.app.users.application.core.domain.Profile;

import java.util.Set;

public interface FindProfileAdapterPort {
    Profile findProfileBydId(Long id);

    Profile findProfileBydIdWithAbilities(Long id);

    Set<Profile> getAllProfiles();

    Profile findProfileByName(String name);
}
