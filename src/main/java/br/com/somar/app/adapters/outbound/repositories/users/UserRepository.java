package br.com.somar.app.adapters.outbound.repositories.users;

import br.com.somar.app.adapters.outbound.repositories.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    @EntityGraph(attributePaths = {"profiles",
            "profiles.abilities",
            "profiles.abilities.abilityCategory",
            "profiles.abilities.abilityCategory",
            "profiles.abilities.abilityGroup"})
    UserEntity findUserWithProfileAndAuthoritiesByEmail(String email);

}
