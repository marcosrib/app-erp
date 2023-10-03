package br.com.somar.app.users.adapters.outbound.repositories.profiles;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.ports.out.profiles.FindAllProfileAdapterPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProfileAdapter implements FindAllProfileAdapterPort {
    private final ProfileRepository profileRepository;

    public FindAllProfileAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return  Profile.convertListProfileEntityIntoListProfile(profileRepository.findAll());
    }
}
