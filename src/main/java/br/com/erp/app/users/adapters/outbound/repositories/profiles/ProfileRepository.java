package br.com.erp.app.users.adapters.outbound.repositories.profiles;

import br.com.erp.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    ProfileEntity findProfileByName(String name);

}
