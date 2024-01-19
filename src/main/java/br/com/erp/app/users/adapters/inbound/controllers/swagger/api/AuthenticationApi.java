package br.com.erp.app.users.adapters.inbound.controllers.swagger.api;

import br.com.erp.app.common.exceptions.handler.ErrorResponse;
import br.com.erp.app.users.adapters.inbound.controllers.requests.AuthenticationRequest;
import br.com.erp.app.users.adapters.inbound.controllers.requests.RefreshTokenRequest;
import br.com.erp.app.users.adapters.inbound.controllers.responses.authentication.AuthenticationResponse;
import br.com.erp.app.users.adapters.inbound.controllers.responses.authentication.RefreshTokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Autenticação API")
public interface AuthenticationApi {
    @Operation(summary = "Logar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Não autorizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Não autorizado.\",\"status\":401,\"error_code\":\"UNAUTHORIZED\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    AuthenticationResponse login(@RequestBody AuthenticationRequest data);

    @Operation(summary = "Refresh token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Não autorizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Não autorizado.\",\"status\":401,\"error_code\":\"UNAUTHORIZED\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest data);
}
