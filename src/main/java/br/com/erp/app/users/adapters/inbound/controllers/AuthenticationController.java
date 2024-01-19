package br.com.erp.app.users.adapters.inbound.controllers;

import br.com.erp.app.users.adapters.inbound.controllers.requests.AuthenticationRequest;
import br.com.erp.app.users.adapters.inbound.controllers.requests.RefreshTokenRequest;
import br.com.erp.app.users.adapters.inbound.controllers.responses.authentication.AuthenticationResponse;
import br.com.erp.app.users.adapters.inbound.controllers.responses.authentication.RefreshTokenResponse;
import br.com.erp.app.users.adapters.inbound.controllers.swagger.api.AuthenticationApi;
import br.com.erp.app.users.application.ports.in.authentication.AuthenticationUseCasePort;
import br.com.erp.app.users.application.ports.in.authentication.RefreshTokenUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController implements AuthenticationApi {
    private final AuthenticationUseCasePort authenticationUseCasePort;
    private final RefreshTokenUseCasePort refreshTokenUseCasePort;

    public AuthenticationController(AuthenticationUseCasePort authenticationUseCasePort, RefreshTokenUseCasePort refreshTokenUseCasePort) {
        this.authenticationUseCasePort = authenticationUseCasePort;
        this.refreshTokenUseCasePort = refreshTokenUseCasePort;
    }

    @PostMapping("/login/")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse login(@RequestBody AuthenticationRequest data) {
        return AuthenticationResponse.fromDomain(authenticationUseCasePort.auth(data.toAuthDomain()));
    }

    @PostMapping("/refresh/")
    @ResponseStatus(HttpStatus.OK)
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest data) {
        String accessToken = refreshTokenUseCasePort.refreshToken(data.refreshToken());
        return RefreshTokenResponse.builder().accessToken(accessToken).build();
    }
}
