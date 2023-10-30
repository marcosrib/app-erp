package br.com.somar.app.unit.users.builders.domain;

import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.common.fakerutils.FakerBuilderSet;
import net.datafaker.Faker;

import java.util.Locale;

public class AbilityFakeBuilder extends FakerBuilderSet {
    @Override
    public Ability getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return Ability
                .builder()
                .id(faker.number().randomNumber())
                .abilityGroup(new AbilityGroupFakeBuilder().getFake())
                .abilityCategory(new AbilityCategoryFakeBuilder().getFake())
                .build();
    }
}
