package br.com.erp.app.users.adapters.outbound.repositories.profiles;

import br.com.erp.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.erp.app.users.application.core.domain.Profile;
import br.com.erp.app.users.application.ports.out.profiles.CreateProfileAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateProfileAdapter implements CreateProfileAdapterPort {
    private final ProfileRepository profileRepository;

    public CreateProfileAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void create(Profile profile) {
        ProfileEntity profileEntity = ProfileEntityMapper.convertProfileToEntityWithAbilities(profile);
        profileRepository.save(profileEntity);
    }
}
