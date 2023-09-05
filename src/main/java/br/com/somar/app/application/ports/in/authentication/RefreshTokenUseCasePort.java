package br.com.somar.app.application.ports.in.authentication;

public interface RefreshTokenUseCasePort {
    String refreshToken(String refreshToken);
}
