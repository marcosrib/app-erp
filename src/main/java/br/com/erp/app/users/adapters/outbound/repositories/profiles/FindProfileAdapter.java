package br.com.erp.app.users.adapters.outbound.repositories.profiles;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.erp.app.users.application.core.domain.Profile;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FindProfileAdapter implements FindProfileAdapterPort {
    @Autowired
    private ProfileRepository profileRepository;
    private List<Profile> profiles;

    @Override
    public Profile findProfileBydId(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile.not.found"));
        return Profile.convertProfileEntityToProfile(profileEntity);
    }

    @Override
    public Profile findProfileBydIdWithAbilities(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile.not.found"));
        return Profile.convertProfileEntityToProfileWithAbilities(profileEntity);
    }

    @Override
    public Set<Profile> getAllProfiles() {
        var profiles = Profile.convertListProfileEntityIntoListProfile(profileRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        return profiles;
    }

    @Override
    public Profile findProfileByName(String name) {
        return Profile.convertProfileEntityToProfile(profileRepository.findProfileByName(name));
    }
}
