package br.com.somar.app.users.adapters.inbound.controllers.swagger.api;

import br.com.somar.app.common.exceptions.handler.ErrorResponse;
import br.com.somar.app.users.adapters.inbound.controllers.requests.ProfileWithAbilitiesRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.profiles.ProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Tag(name = "Perfil API")
public interface PerfilApi {

    @Operation(summary = "Cadastra perfil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    void create(@RequestBody ProfileWithAbilitiesRequest profileRequest);

    @Operation(summary = "Edita perfil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Perfil não encontrado\",\"status\":404,\"error_code\":\"NOT_FOUND\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),

            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    void update(@Valid @RequestBody ProfileWithAbilitiesRequest profileRequest, @PathVariable Long profileId);

    @Operation(summary = "Lista todos perfis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    Set<ProfileResponse> index();

    @Operation(summary = "Busca perfil por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Perfil não encontrado\",\"status\":404,\"error_code\":\"NOT_FOUND\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),

            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    ProfileResponse show(@PathVariable Long profileId);
}