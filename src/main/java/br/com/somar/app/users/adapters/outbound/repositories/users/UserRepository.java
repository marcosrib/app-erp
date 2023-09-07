package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    @EntityGraph(attributePaths = {"profiles",
            "profiles.abilities",
            "profiles.abilities.abilityCategory",
            "profiles.abilities.abilityCategory",
            "profiles.abilities.abilityGroup"})
    UserEntity findUserWithProfileAndAuthoritiesByEmail(String email);

}
