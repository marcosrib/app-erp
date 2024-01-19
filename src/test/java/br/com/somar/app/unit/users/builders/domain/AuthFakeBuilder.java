package br.com.erp.app.unit.users.builders.domain;

import br.com.erp.app.users.application.core.domain.Auth;
import net.datafaker.Faker;

import java.util.Locale;

public class AuthFakeBuilder {
    public Auth getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return Auth.builder()
                .name(faker.name().title())
                .password(faker.random().hex());
    }
}
