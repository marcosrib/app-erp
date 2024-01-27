package br.com.erp.app.unit.users.builders.fileproperties;

import br.com.erp.app.common.fakerutils.FakerBuilderList;
import br.com.erp.app.users.adapters.outbound.fileproperties.GroupFileProperties;
import net.datafaker.Faker;

import java.util.Locale;

public class GroupFilePropertiesFakeBuilder extends FakerBuilderList {
    public GroupFileProperties getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        var groupFileProperties = new GroupFileProperties();
        groupFileProperties.setCode(faker.name().name().toUpperCase());
        groupFileProperties.setName(faker.name().name());
        groupFileProperties.setAbilities(new AbilityFilePropertiesFakeBuilder().getFake(3));
        return groupFileProperties;
    }
}
