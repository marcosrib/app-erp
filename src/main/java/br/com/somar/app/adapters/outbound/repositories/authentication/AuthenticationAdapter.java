package br.com.somar.app.adapters.outbound.repositories.authentication;

import br.com.somar.app.adapters.outbound.jwt.JwtAdapter;
import br.com.somar.app.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.adapters.outbound.repositories.users.UserRepository;
import br.com.somar.app.application.domain.Auth;
import br.com.somar.app.application.ports.out.auth.AuthenticationAdapterPort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        UserDetails userDetails = loadUserByUsername(auth.getEmail());
        boolean isPasswordMatch = passwordEncoder.matches(auth.getPassword(), userDetails.getPassword());
        if(isPasswordMatch) {
            return Auth
                .builder()
                .accessToken(jwtAdapter.generateAccessToken(auth))
                .refreshToken(jwtAdapter.generateRefreshToken(auth));
        }
        return null;
    }

    public UserDetails loadUserByUsername(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        List<String> listRoles = new ArrayList<>();

        userEntity.getProfiles().forEach(role -> listRoles.add(role.getName().toString()));
        String[] roles = listRoles.stream().toArray(n -> new String[n]);

        return User.builder()
                .username(userEntity.getEmail()).password(userEntity.getPassword()).roles(roles).build();
    }
}

