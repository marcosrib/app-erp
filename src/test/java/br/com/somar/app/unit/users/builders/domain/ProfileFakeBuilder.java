package br.com.somar.app.unit.users.builders.domain;

import br.com.somar.app.common.fakerutils.FakerBuilderSet;
import br.com.somar.app.users.application.core.domain.Profile;
import net.datafaker.Faker;

import java.util.Locale;

public class ProfileFakeBuilder extends FakerBuilderSet<Profile> {

    @Override
    public Profile getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return new Profile(faker.number().randomNumber(), faker.name().title());
    }


}
