package br.com.somar.app.unit.users.builders.domain;

import br.com.somar.app.users.application.core.domain.AbilityCategory;
import br.com.somar.app.common.fakerutils.FakerBuilderSet;
import net.datafaker.Faker;

import java.util.Locale;

public class AbilityCategoryFakeBuilder extends FakerBuilderSet {

    public AbilityCategory getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return new AbilityCategory(faker.number().randomNumber(), faker.name().title(), faker.name().title());
    }
}
