package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.requests.CreateUserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UpdateUserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UserFilterRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.PageResponse;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.UserResponse;
import br.com.somar.app.users.adapters.inbound.controllers.swagger.api.UserApi;
import br.com.somar.app.users.application.core.domain.PageDomain;
import br.com.somar.app.users.application.core.domain.PageableRequestDomain;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.application.ports.in.users.FindPaginationUserUseCasePort;
import br.com.somar.app.users.application.ports.out.users.UpdateUserAdapterPort;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController implements UserApi {
    private final CreateUserUseCasePort createUserUseCasePort;
    private final UpdateUserAdapterPort updateUserUseCasePort;
    private final FindPaginationUserUseCasePort findPaginationUserUseCasePort;
    public UserController(CreateUserUseCasePort createUserUseCasePort, UpdateUserAdapterPort updateUserUseCasePort, FindPaginationUserUseCasePort findPaginationUserUseCasePort) {
        this.createUserUseCasePort = createUserUseCasePort;
        this.updateUserUseCasePort = updateUserUseCasePort;
        this.findPaginationUserUseCasePort = findPaginationUserUseCasePort;
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest userRequest) {
        return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse update(@Valid @RequestBody UpdateUserRequest userRequest) {
        return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
    }
    @PreAuthorize("hasAuthority('FINANCEIRO_CREATE')")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<UserResponse> index(UserFilterRequest filter, Pageable pageable) {
        System.out.println("passo");
        var pageableRequestDomain = new PageableRequestDomain(pageable.getPageNumber(),pageable.getPageSize());
        PageDomain<User> userPage = findPaginationUserUseCasePort.getUsersWithPaginationAndFilter(filter.toUserDomain(), pageableRequestDomain);
        List<UserResponse> userResponses = UserResponse.fromDomainToList(userPage.getData());

      return PageResponse.builder()
                .data(userResponses)
                .previousPage(userPage.getPreviousPage())
                .totalElements(userPage.getTotalElements())
                .totalPages(userPage.getTotalPages())
                .nextPage(userPage.getNextPage())
                .currentPage(userPage.getCurrentPage());
    }
}
