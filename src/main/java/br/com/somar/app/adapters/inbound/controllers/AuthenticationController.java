package br.com.somar.app.adapters.inbound.controllers;

import br.com.somar.app.adapters.inbound.controllers.requests.AuthenticationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody AuthenticationRequest data) {
        return "";
    }
}
