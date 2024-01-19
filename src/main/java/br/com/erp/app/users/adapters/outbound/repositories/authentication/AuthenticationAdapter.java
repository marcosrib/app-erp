package br.com.erp.app.users.adapters.outbound.repositories.authentication;

import br.com.erp.app.common.exceptions.UnauthorizedException;
import br.com.erp.app.users.adapters.outbound.jwt.JwtAdapter;
import br.com.erp.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.erp.app.users.adapters.outbound.repositories.users.UserRepository;
import br.com.erp.app.users.application.core.domain.Auth;
import br.com.erp.app.users.application.ports.out.auth.AuthenticationAdapterPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        auth.name(userEntity.getName());
        return Auth.convertUserEntityToAuth(userEntity, jwtAdapter.generateAccessToken(auth), jwtAdapter.generateRefreshToken(auth));
    }

    @Override
    public Auth findUserWithProfileAndAuthoritiesByEmail(String email) {
        var userEntity = userRepository.findUserWithProfileAndAuthoritiesByEmail(email);
        if (ObjectUtils.isEmpty(userEntity)) {
            throw new UnauthorizedException("user.unauthorized");
        }
        return Auth.convertUserEntityToAuth(userEntity);
    }

}

