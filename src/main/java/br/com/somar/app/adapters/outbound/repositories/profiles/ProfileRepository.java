package br.com.somar.app.adapters.outbound.repositories.profiles;

import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
