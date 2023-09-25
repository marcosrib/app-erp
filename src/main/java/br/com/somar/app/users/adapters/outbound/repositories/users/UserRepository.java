package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    @Query("SELECT u FROM UserEntity u " +
            "LEFT JOIN FETCH u.profiles p " +
            "LEFT JOIN FETCH p.abilities a " +
            "LEFT JOIN FETCH a.abilityCategory ac " +
            "LEFT JOIN FETCH a.abilityGroup ag " +
            "WHERE u.email = :email")
    UserEntity findUserWithProfileAndAuthoritiesByEmail(@Param("email") String email);


    @Query("SELECT u FROM UserEntity u " +
            "LEFT JOIN FETCH u.profiles p WHERE u IN :users ")
    List<UserEntity> findUserWithProfilesByIn(List<UserEntity> users);

    Page<UserEntity> findAll(Specification<User> spec, Pageable pageable);
}
