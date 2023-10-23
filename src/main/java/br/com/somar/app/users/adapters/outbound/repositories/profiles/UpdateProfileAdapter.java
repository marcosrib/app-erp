package br.com.somar.app.users.adapters.outbound.repositories.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.ports.out.profiles.UpdateProfileAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfileAdapter implements UpdateProfileAdapterPort {
    private final ProfileRepository profileRepository;

    public UpdateProfileAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void update(Profile profile) {
        profileRepository.save(ProfileEntityMapper.convertProfileToEntityWithAbilities(profile));
    }
}
