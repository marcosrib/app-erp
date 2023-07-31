package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.requests.AuthenticationRequest;
import br.com.somar.app.application.ports.in.AuthenticationUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
   private final AuthenticationUseCasePort authenticationUseCasePort;
    public AuthenticationController(AuthenticationUseCasePort authenticationUseCasePort) {
        this.authenticationUseCasePort = authenticationUseCasePort;
    }

    @PostMapping("/login/")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody AuthenticationRequest data) {
        System.out.println(data.toAuthDomain());
        return authenticationUseCasePort.auth(data.toAuthDomain());
    }
}
