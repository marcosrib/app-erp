package br.com.somar.app.users.application.ports.out.users;

public interface PasswordEncoderAdapterPort {
    String encoderPassword(String password);
}
