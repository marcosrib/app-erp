package br.com.somar.app.users.application.ports.in.profiles;

import br.com.somar.app.users.application.core.domain.Profile;

import java.util.List;

public interface FindAllProfileUseCasePort {
    List<Profile> getAllProfiles();
}
