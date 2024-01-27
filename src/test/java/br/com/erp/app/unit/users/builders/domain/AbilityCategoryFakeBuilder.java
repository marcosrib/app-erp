package br.com.erp.app.unit.users.builders.domain;

import br.com.erp.app.common.fakerutils.FakerBuilderSet;
import br.com.erp.app.users.application.core.domain.AbilityCategory;
import net.datafaker.Faker;

import java.util.Locale;

public class AbilityCategoryFakeBuilder extends FakerBuilderSet {

    public AbilityCategory getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return new AbilityCategory(faker.number().randomNumber(), faker.name().title(), faker.name().title());
    }
}
