package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.requests.UserFilterRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.PageResponse;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.UserResponse;
import br.com.somar.app.users.application.core.domain.PageDomain;
import br.com.somar.app.users.application.core.domain.PageableRequestDomain;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.application.ports.in.users.FindPaginationUserUseCasePort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final CreateUserUseCasePort createUserUseCasePort;

    private final FindPaginationUserUseCasePort findPaginationUserUseCasePort;
    public UserController(CreateUserUseCasePort createUserUseCasePort, FindPaginationUserUseCasePort findPaginationUserUseCasePort) {
        this.createUserUseCasePort = createUserUseCasePort;
        this.findPaginationUserUseCasePort = findPaginationUserUseCasePort;
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
    }
    @PreAuthorize("hasAuthority('FINANCEIRO_CREATE')")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse index(UserFilterRequest filter, Pageable pageable) {
        var pageableRequestDomain = new PageableRequestDomain(pageable.getPageNumber(),pageable.getPageSize());
        PageDomain<User> userPage = findPaginationUserUseCasePort.getUsersWithPaginationAndFilter(filter.toUserDomain(), pageableRequestDomain);
        var userResponses = UserResponse.fromDomainToList(userPage.getData());
        return PageResponse.builder()
                .data(Collections.singletonList(userResponses))
                .previousPage(userPage.getPreviousPage())
                .totalElements(userPage.getTotalElements())
                .totalPages(userPage.getTotalPages())
                .nextPage(userPage.getNextPage())
                .currentPage(userPage.getCurrentPage())
                .build();
    }
}
