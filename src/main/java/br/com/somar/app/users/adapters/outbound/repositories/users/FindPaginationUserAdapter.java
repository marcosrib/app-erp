package br.com.somar.app.users.adapters.outbound.repositories.users;

import br.com.somar.app.users.adapters.outbound.repositories.entity.UserEntity;
import br.com.somar.app.users.application.core.domain.PageDomain;
import br.com.somar.app.users.application.core.domain.PageableRequestDomain;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.out.users.FindPaginationUserAdapterPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindPaginationUserAdapter implements FindPaginationUserAdapterPort {

    private final UserRepository userRepository;

    public FindPaginationUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PageDomain<User> findUsersWithPagination(User filter, PageableRequestDomain pageable) {

        Specification<User> spec = Specification.where(null);

        if (ObjectUtils.isEmpty(filter)) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("email"), "%" + filter.getEmail() + "%"));
        }

        Page<UserEntity> userEntityPage = userRepository.findAll(spec, PageRequest.of(pageable.page(),pageable.size(), Sort.by(Sort.Direction.DESC, "id")));
        userRepository.findUserWithProfilesByIn(userEntityPage.stream().collect(Collectors.toList()));
        List<User> users = User.convertPageUserEntityToListUser(userEntityPage);
        return PageDomain.builder()
                .data(users)
                .totalPages(userEntityPage.getTotalPages())
                .totalElements(userEntityPage.getTotalElements())
                .currentPage(userEntityPage.getNumber())
                .nextPage()
                .previousPage();
    }

}
