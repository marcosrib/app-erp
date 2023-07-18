package br.com.somar.app.adapters.outbound.repositories.users;

import br.com.somar.app.adapters.outbound.repositories.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
