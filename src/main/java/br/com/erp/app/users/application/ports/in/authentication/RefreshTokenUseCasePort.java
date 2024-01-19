package br.com.erp.app.users.application.ports.in.authentication;

public interface RefreshTokenUseCasePort {
    String refreshToken(String refreshToken);
}
