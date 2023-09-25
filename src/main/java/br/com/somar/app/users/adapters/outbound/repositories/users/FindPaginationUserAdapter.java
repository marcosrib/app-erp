package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.FindPaginationUserAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.stream.Collectors;

@Service
public class FindPaginationUserAdapter implements FindPaginationUserAdapterPort {

    private final UserRepository userRepository;

    public FindPaginationUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findUsersWithPagination(User filter, Pageable pageable) {

        Specification<User> spec = Specification.where(null);

        if (ObjectUtils.isEmpty(filter)) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("email"), "%" + filter.getEmail() + "%"));
        }
        Page<UserEntity> userEntityPage =  userRepository.findAll(spec, pageable);
        userRepository.findUserWithProfilesByIn(userEntityPage.stream().collect(Collectors.toList()));
        return User.convertPageUserEntityToPageUser(userEntityPage);
    }
}
