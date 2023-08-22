package br.com.somar.app.adapters.outbound.repositories.profiles;

import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.application.domain.Profile;
import br.com.somar.app.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.common.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindProfileAdapter implements FindProfileAdapterPort {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile findProfileBydId(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile.not.found"));

        return Profile.convertProfileEntityToProfile(profileEntity);
    }
}
