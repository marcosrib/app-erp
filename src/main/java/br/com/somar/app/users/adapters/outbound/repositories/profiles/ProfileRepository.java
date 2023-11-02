package br.com.somar.app.users.adapters.outbound.repositories.profiles;

import br.com.somar.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
 ProfileEntity findProfileByName(String name);
}
