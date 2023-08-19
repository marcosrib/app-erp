package br.com.somar.app.adapters.outbound.repositories.authentication;

import br.com.somar.app.adapters.outbound.jwt.JwtAdapter;
import br.com.somar.app.adapters.outbound.repositories.entity.AbilityEntity;
import br.com.somar.app.adapters.outbound.repositories.entity.ProfileEntity;
import br.com.somar.app.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.application.domain.Auth;
import br.com.somar.app.application.domain.User;
import br.com.somar.app.application.ports.out.auth.AuthenticationAdapterPort;
import br.com.somar.app.exceptions.UnauthorizedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthenticationAdapter implements AuthenticationAdapterPort {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtAdapter jwtAdapter;

    public AuthenticationAdapter(
            PasswordEncoder passwordEncoder, UserRepository userRepository, JwtAdapter jwtAdapter) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtAdapter = jwtAdapter;
    }

    @Override
    public Auth authenticate(Auth auth) {
        UserEntity userEntity = userRepository.findByEmail(auth.getEmail());
        if (ObjectUtils.isEmpty(userEntity)) {
            throw new UnauthorizedException("user.unauthorized");
        }
        boolean isPasswordMatch = passwordEncoder.matches(auth.getPassword(), userEntity.getPassword());
        if (!isPasswordMatch) {
            throw new UnauthorizedException("user.unauthorized");
        }
        return Auth.convertUserEntityToAuth(userEntity, jwtAdapter.generateAccessToken(auth), jwtAdapter.generateRefreshToken(auth));
    }

    @Override
    public Auth findUserWithProfileAndAuthoritiesByEmail(String email) {
        var userEntity = userRepository.findUserWithProfileAndAuthoritiesByEmail(email);
        if(ObjectUtils.isEmpty(userEntity)) {
            throw new UnauthorizedException("user.unauthorized");
        }
        return Auth.convertUserEntityToAuth(userEntity);
    }

}

