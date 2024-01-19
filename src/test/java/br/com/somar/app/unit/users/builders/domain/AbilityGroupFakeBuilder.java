package br.com.erp.app.unit.users.builders.domain;

import br.com.erp.app.users.application.core.domain.AbilityGroup;
import net.datafaker.Faker;

import java.util.Locale;

public class AbilityGroupFakeBuilder {
    public AbilityGroup getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return new AbilityGroup(faker.number().randomNumber(), faker.name().title(), faker.name().title());
    }
}
