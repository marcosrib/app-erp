package br.com.somar.app.users.adapters.inbound.controllers;

import br.com.somar.app.users.adapters.inbound.controllers.requests.CreateUserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UpdateUserStatusRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UserFilterRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.UserResponse;
import br.com.somar.app.users.application.core.domain.User;
import br.com.somar.app.users.application.ports.in.users.CreateUserUseCasePort;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UpdateUserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.PageResponse;
import br.com.somar.app.users.adapters.inbound.controllers.swagger.api.UserApi;
import br.com.somar.app.users.application.core.domain.PageDomain;
import br.com.somar.app.users.application.core.domain.PageableRequestDomain;
import br.com.somar.app.users.application.ports.in.users.FindPaginationUserUseCasePort;
import br.com.somar.app.users.application.ports.in.users.UpdateUserStatusUseCasePort;
import br.com.somar.app.users.application.ports.in.users.UpdateUserUseCasePort;
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
    private final UpdateUserUseCasePort updateUserUseCasePort;
    private final FindPaginationUserUseCasePort findPaginationUserUseCasePort;
    private final UpdateUserStatusUseCasePort updateUserStatusUseCasePort;
    public UserController(CreateUserUseCasePort createUserUseCasePort, UpdateUserUseCasePort updateUserUseCasePort, FindPaginationUserUseCasePort findPaginationUserUseCasePort, UpdateUserStatusUseCasePort updateUserStatusUseCasePort) {
        this.createUserUseCasePort = createUserUseCasePort;
        this.updateUserUseCasePort = updateUserUseCasePort;
        this.findPaginationUserUseCasePort = findPaginationUserUseCasePort;
        this.updateUserStatusUseCasePort = updateUserStatusUseCasePort;
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateUserRequest userRequest) {
        createUserUseCasePort.create(userRequest.toUserDomain());
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody UpdateUserRequest userRequest, @PathVariable Long id) {
        updateUserUseCasePort.update(id, userRequest.toUserDomain());
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<UserResponse> index(UserFilterRequest filter, Pageable pageable) {
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

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateStatus(@RequestBody UpdateUserStatusRequest UpdateUserStatusRequest, @PathVariable Long userId) {
        updateUserStatusUseCasePort.updateStatus(userId, UpdateUserStatusRequest.status());
    }
}
