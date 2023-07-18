package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.requests.UserRequest;
import br.com.somar.app.adapters.inbound.controllers.responses.UserResponse;
import br.com.somar.app.application.ports.in.users.CreateUserUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final CreateUserUseCasePort createUserUseCasePort;

    public UserController(CreateUserUseCasePort createUserUseCasePort) {
        this.createUserUseCasePort = createUserUseCasePort;

    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String index() {
        return "teset";
    }
}
