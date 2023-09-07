package br.com.somar.app.users.application.ports.in.authentication;

public interface RefreshTokenUseCasePort {
    String refreshToken(String refreshToken);
}
