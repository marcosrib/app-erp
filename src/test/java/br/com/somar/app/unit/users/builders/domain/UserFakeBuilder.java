package br.com.somar.app.unit.users.builders.domain;

import br.com.somar.app.users.application.core.domain.User;
import net.datafaker.Faker;

import java.util.Locale;

public class UserFakeBuilder {


    public static User getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        var profileFaker = new ProfileFakeBuilder();
        return User
                .builder()
                .id(faker.number().randomNumber())
                .name(faker.artist().name())
                .email(faker.internet().emailAddress())
                .status(true)
                .profiles(profileFaker.getFake(1))
                .build();
    }

}
