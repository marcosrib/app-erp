package br.com.somar.app.adapters.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String create() {
        return "teset";
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String index() {
        return "teset";
    }
}
