package br.com.somar.app.adapters.inbound.controllers.swagger.api;

import br.com.somar.app.adapters.inbound.controllers.requests.AuthenticationRequest;
import br.com.somar.app.adapters.inbound.controllers.responses.authentication.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Autenticação API")
public interface AuthenticationApi {
    @Operation(summary = "Logar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
    })
    AuthenticationResponse login(@RequestBody AuthenticationRequest data);
}
