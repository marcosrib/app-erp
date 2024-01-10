package br.com.somar.app.unit.users.builders.domain;

import br.com.somar.app.users.application.core.domain.Auth;
import br.com.somar.app.users.application.core.domain.Profile;
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
