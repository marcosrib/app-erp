package br.com.erp.app.users.adapters.outbound.repositories.users;

import br.com.erp.app.users.application.ports.out.users.PasswordEncoderAdapterPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderAdapter implements PasswordEncoderAdapterPort {
    private final PasswordEncoder encoder;

    public PasswordEncoderAdapter(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encoderPassword(String password) {
        return encoder.encode(password);
    }
}
