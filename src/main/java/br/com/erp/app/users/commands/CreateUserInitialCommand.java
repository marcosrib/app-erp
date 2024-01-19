package br.com.erp.app.users.commands;

import br.com.erp.app.users.adapters.outbound.repositories.users.FindUserAdapter;
import br.com.erp.app.users.application.core.domain.Ability;
import br.com.erp.app.users.application.core.domain.Profile;
import br.com.erp.app.users.application.core.domain.User;
import br.com.erp.app.users.application.core.usecases.abilities.CreateAbilityUseCase;
import br.com.erp.app.users.application.core.usecases.users.CreateUserUseCase;
import br.com.erp.app.users.application.ports.out.abilities.FindAbilityAdapterPort;
import br.com.erp.app.users.application.ports.out.profiles.CreateProfileAdapterPort;
import br.com.erp.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.erp.app.users.application.ports.out.users.FindUserAdapterPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Set;

@Component
public class CreateUserInitialCommand implements CommandLineRunner {
    private final String ADMIN = "Administrador";
    private final FindUserAdapterPort findUserAdapter;
    private final CreateUserUseCase createUserAdapter;
    private final CreateAbilityUseCase createAbilityUseCase;
    private final FindAbilityAdapterPort findAbilityAdapterPort;
    private final FindProfileAdapterPort findProfileAdapterPort;
    private final CreateProfileAdapterPort createProfileAdapterPort;
    @Value("${spring.user.admin.email}")
    private String email;
    @Value("${spring.user.admin.password}")
    private String password;

    public CreateUserInitialCommand(FindUserAdapter findUserAdapter,
                                    CreateUserUseCase createUserAdapter, CreateAbilityUseCase createAbilityUseCase, FindAbilityAdapterPort findAbilityAdapterPort, FindProfileAdapterPort findProfileAdapterPort, CreateProfileAdapterPort createProfileAdapterPort) {
        this.findUserAdapter = findUserAdapter;
        this.createUserAdapter = createUserAdapter;
        this.createAbilityUseCase = createAbilityUseCase;
        this.findAbilityAdapterPort = findAbilityAdapterPort;
        this.findProfileAdapterPort = findProfileAdapterPort;
        this.createProfileAdapterPort = createProfileAdapterPort;
    }

    @Override
    public void run(String... args) throws Exception {
        var user = findUserAdapter.findByEmail(email);
        createAbilityUseCase.create();
        var abilities = findAbilityAdapterPort.findAllAbilities();
        if (abilities.isEmpty()) {
            return;
        }

        addAbilitiesIntoProfile(abilities);
        var profile = findProfileAdapterPort.findProfileByName(ADMIN);
        if (ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(profile)) {
            createUserAdapter.create(User
                    .builder()
                    .name(ADMIN)
                    .email(email)
                    .password(password)
                    .status(true)
                    .profiles(Set.of(profile))
                    .build());
        }
    }

    private void addAbilitiesIntoProfile(Set<Ability> abilities) {
        var profile = findProfileAdapterPort.findProfileByName(ADMIN);
        if (ObjectUtils.isEmpty(profile)) {
            var newProfile = new Profile();
            newProfile.setName(ADMIN);
            newProfile.setAbilities(abilities);
            createProfileAdapterPort.create(newProfile);
        }
    }
}
