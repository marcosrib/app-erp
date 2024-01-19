package br.com.erp.app.unit.users.builders.repositories.entities;

import br.com.erp.app.common.fakerutils.FakerBuilderSet;
import br.com.erp.app.users.adapters.outbound.repositories.entity.ProfileEntity;
import net.datafaker.Faker;

import java.util.Locale;

public class ProfileEntityFakeBuilder extends FakerBuilderSet<ProfileEntity> {
    @Override
    public ProfileEntity getFake() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return ProfileEntity.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().title())
                .build();
    }

}
