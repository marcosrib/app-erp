package br.com.erp.app.unit.users.builders.domain;

import br.com.erp.app.common.fakerutils.FakerBuilderSet;
import br.com.erp.app.users.application.core.domain.Profile;
import net.datafaker.Faker;

import java.util.Locale;

public class ProfileFakeBuilder extends FakerBuilderSet<Profile> {

    public Profile getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return Profile
                .builder()
                .id(faker.number().randomNumber())
                .name(faker.name().title())
                .build();
    }


}
