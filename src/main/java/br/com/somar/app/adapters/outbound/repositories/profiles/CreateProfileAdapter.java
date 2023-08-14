package br.com.somar.app.adapters.outbound.repositories.profiles;

import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.application.domain.Profile;
import br.com.somar.app.application.ports.out.profiles.CreateProfileAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateProfileAdapter implements CreateProfileAdapterPort {
    private final ProfileRepository profileRepository;

    public CreateProfileAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    @Override
    public Profile create(Profile profile) {
        ProfileEntity profileEntity = ProfileEntity
                .builder()
                .name(profile.getName())
                .build();
         profileRepository.save(profileEntity);
        return Profile.convertProfileEntityToProfile(profileRepository.save(profileEntity));
    }
}
