package br.com.somar.app.users.application.core.usecases.Auth;

import br.com.somar.app.users.adapters.outbound.jwt.JwtAdapter;
import br.com.somar.app.users.application.core.domain.Auth;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.authentication.RefreshTokenUseCasePort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.common.exceptions.UnauthorizedException;
import org.springframework.util.ObjectUtils;

public class RefreshTokenUseCase implements RefreshTokenUseCasePort {
    private final JwtAdapter jwtAdapter;
    private final FindUserAdapterPort findUserAdapterPort;
    public RefreshTokenUseCase(JwtAdapter jwtAdapter, FindUserAdapterPort findUserAdapterPort) {
        this.jwtAdapter = jwtAdapter;
        this.findUserAdapterPort = findUserAdapterPort;
    }

    @Override
    public String refreshToken(String refreshToken) {
        String email = jwtAdapter.validateToken(refreshToken);
        if(ObjectUtils.isEmpty(email)) {
            throw new UnauthorizedException("auth.unauthorized");
        }
         User user = findUserAdapterPort.findByEmail(email);
         if(ObjectUtils.isEmpty(user) ||  !user.isStatus()) {
             throw new UnauthorizedException("auth.unauthorized");
         }

        return jwtAdapter.generateAccessToken(Auth.convertUserEntityToAuth(user));
    }
}
