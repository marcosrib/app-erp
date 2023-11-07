package br.com.somar.app.users.application.core.usecases.users;

import br.com.somar.app.users.application.core.domain.Profile;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.UpdateUserUseCasePort;
import br.com.somar.app.users.application.ports.out.profiles.FindProfileAdapterPort;
import br.com.somar.app.users.application.ports.out.users.FindUserAdapterPort;
import br.com.somar.app.users.application.ports.out.users.PasswordEncoderAdapterPort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashSet;
import java.util.Optional;


public class UpdateUserUseCase implements UpdateUserUseCasePort {
    private final UpdateUserAdapterPort updateUserAdapterPort;
    private final FindUserAdapterPort findUserAdapterPort;

    private final FindProfileAdapterPort findProfileAdapterPort;

    private final PasswordEncoderAdapterPort passwordEncoderAdapterPort;

    public UpdateUserUseCase(UpdateUserAdapterPort updateUserAdapterPort, FindUserAdapterPort findUserAdapterPort, FindProfileAdapterPort findProfileAdapterPort, PasswordEncoderAdapterPort passwordEncoderAdapterPort) {
        this.updateUserAdapterPort = updateUserAdapterPort;
        this.findProfileAdapterPort = findProfileAdapterPort;
        this.passwordEncoderAdapterPort = passwordEncoderAdapterPort;
        this.findUserAdapterPort = findUserAdapterPort;
    }
    @Override
    public void update(Long id, User user) {
         var existingUser = findUserAdapterPort.findById(id);
         verifyProfileExists(user, existingUser);
         verifyPasswordIsEmpty(user, existingUser);
         existingUser.setName(user.getName());
         existingUser.setEmail(user.getEmail());

        updateUserAdapterPort.update(existingUser);
    }
    private void verifyPasswordIsEmpty(User user, User userExist) {
        if(ObjectUtils.isEmpty(user.getPassword())) {
           userExist.setPassword(userExist.getPassword());
        }
        if(ObjectUtils.isNotEmpty(user.getPassword())) {
            var passwordEncoded = passwordEncoderAdapterPort.encoderPassword(user.getPassword());
            userExist.setPassword(passwordEncoded);
        }
    }

    private void verifyProfileExists(User user, User existingUser) {
        Optional<Profile> firstProfile = user.getProfiles().stream()
                .findFirst();
        var profileId =  firstProfile.get().getId();
        Profile existingProfile = findProfileAdapterPort.findProfileBydId(profileId);

        existingUser.setProfiles(new HashSet<>());
        existingUser.getProfiles().add(existingProfile);
    }
}
