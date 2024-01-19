package br.com.erp.app.users.application.ports.out.users;

public interface PasswordEncoderAdapterPort {
    String encoderPassword(String password);
}
