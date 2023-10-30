package br.com.somar.app.unit.users.builders.fileproperties;

import br.com.somar.app.common.fakerutils.FakerBuilderList;
import br.com.somar.app.users.adapters.outbound.fileproperties.AbilityFileProperties;
import net.datafaker.Faker;

import java.util.Locale;

public class AbilityFilePropertiesFakeBuilder extends FakerBuilderList {
    @Override
    public AbilityFileProperties getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        var abilityFileProperties = new AbilityFileProperties();
        abilityFileProperties.setCode(faker.name().title());
        abilityFileProperties.setName(faker.name().title());
        return abilityFileProperties;
    }
}
