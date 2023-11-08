package br.com.somar.app.unit.users.builders.repositories.entities;

import br.com.somar.app.common.fakerutils.FakerBuilderList;
import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import net.datafaker.Faker;

import java.util.Locale;

public class UserEntityFakeBuilder extends FakerBuilderList {
    public UserEntity getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        var profileFaker = new ProfileEntityFakeBuilder();
        return UserEntity
                .builder()
                .id(faker.number().randomNumber())
                .name(faker.artist().name())
                .email(faker.internet().emailAddress())
                .status(true)
                .profiles(profileFaker.getFake(1))
                .build();
    }
}
