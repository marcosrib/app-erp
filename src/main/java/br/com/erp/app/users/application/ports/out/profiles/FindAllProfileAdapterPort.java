package br.com.erp.app.users.application.ports.out.profiles;

import br.com.erp.app.users.application.core.domain.Profile;

import java.util.List;

public interface FindAllProfileAdapterPort {
    List<Profile> getAllProfiles();
}
