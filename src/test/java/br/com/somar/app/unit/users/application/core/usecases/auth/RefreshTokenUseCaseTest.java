package br.com.erp.app.unit.users.application.core.usecases.auth;

import br.com.erp.app.common.exceptions.UnauthorizedException;
import br.com.erp.app.unit.users.builders.domain.UserFakeBuilder;
import br.com.erp.app.users.adapters.outbound.jwt.JwtAdapter;
import br.com.erp.app.users.application.core.domain.Auth;
import br.com.erp.app.users.application.core.usecases.Auth.RefreshTokenUseCase;
import br.com.erp.app.users.application.ports.out.users.FindUserAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RefreshTokenUseCaseTest {
    @InjectMocks
    private RefreshTokenUseCase refreshTokenUseCase;
    @Mock
    private JwtAdapter jwtAdapter;
    @Mock
    private FindUserAdapterPort findUserAdapterPort;

    @DisplayName("should successfully refresh token")
    @Test
    void refreshToken() {
        String token = "rifnjnkeurcheojcreckbjejvrekv";
        String email = "teste@gmail.com";
        var user = new UserFakeBuilder().getFake();
        when(jwtAdapter.validateToken(token)).thenReturn(email);
        when(findUserAdapterPort.findByEmail(email)).thenReturn(user);
        refreshTokenUseCase.refreshToken(token);
        verify(jwtAdapter, times(1)).generateAccessToken(any(Auth.class));
    }

    @DisplayName("Should throw UnauthorizedException when the refresh token is invalid")
    @Test
    void whenValidateTokenReturnsEmpty_ShouldThrowUnauthorizedException() {
        String token = "rifnjnkeurcheojcreckbjejvrekv";
        when(jwtAdapter.validateToken(token)).thenReturn(null);
        assertThrows(UnauthorizedException.class, () -> refreshTokenUseCase.refreshToken(token));
    }

    @DisplayName("Should throw UnauthorizedException when the find user by email not found")
    @Test
    void whenFindByEmailReturnsNull_ShouldThrowUnauthorizedException() {
        String token = "rifnjnkeurcheojcreckbjejvrekv";
        String email = "teste@gmail.com";

        when(jwtAdapter.validateToken(token)).thenReturn(email);
        when(findUserAdapterPort.findByEmail(email)).thenReturn(null);
        assertThrows(UnauthorizedException.class, () -> refreshTokenUseCase.refreshToken(token));
    }
}
