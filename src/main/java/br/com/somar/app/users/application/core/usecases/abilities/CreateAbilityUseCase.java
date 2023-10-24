package br.com.somar.app.users.application.core.usecases.abilities;

import br.com.somar.app.users.adapters.outbound.fileproperties.GetAbilitiesIntoYMLFile;
import br.com.somar.app.users.application.core.domain.Ability;
import br.com.somar.app.users.application.ports.in.abilities.CreateAbilityUseCasePort;
import br.com.somar.app.users.application.ports.out.abilities.CreateAbilityAdapterPort;

import java.util.HashSet;

public class CreateAbilityUseCase implements CreateAbilityUseCasePort {
    private final CreateAbilityAdapterPort createAbilityAdapterPort;
    private final GetAbilitiesIntoYMLFile getAbilitiesIntoYMLFile;
    public CreateAbilityUseCase(CreateAbilityAdapterPort createAbilityAdapterPort, GetAbilitiesIntoYMLFile getAbilitiesIntoYMLFile) {
        this.createAbilityAdapterPort = createAbilityAdapterPort;
        this.getAbilitiesIntoYMLFile = getAbilitiesIntoYMLFile;
    }


    @Override
    public void create() {
        var b =  getAbilitiesIntoYMLFile.getGroups();
        var d = new Ability();
        var a = new HashSet<Ability>();
        a.add(d);
        createAbilityAdapterPort.create(a);
    }
}
