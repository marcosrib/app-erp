package br.com.somar.app.users.adapters.inbound.controllers.swagger.api;

import br.com.somar.app.common.exceptions.handler.ErrorResponse;
import br.com.somar.app.users.adapters.inbound.controllers.requests.CreateUserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UpdateUserRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UpdateUserStatusRequest;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UserFilterRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.UserResponse;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Usuário API")
public interface UserApi {
    @Operation(summary = "Listar usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    PageResponse<UserResponse> index(UserFilterRequest filter, Pageable pageable) throws Exception;

    @Operation(summary = "Cadastra usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "409", description = "Email já está cadastrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Email já está cadastrado.\",\"status\":409,\"error_code\":\"CONFLICT\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            })
    void create(@Valid @RequestBody CreateUserRequest userRequest);

    @Operation(summary = "Atualiza usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Usuário não encontrado.\",\"status\":404,\"error_code\":\"NOT_FOUND\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    void update(@Valid @RequestBody UpdateUserRequest userRequest, @PathVariable Long id);

    @Operation(summary = "Atualiza status do usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Usuário não encontrado.\",\"status\":404,\"error_code\":\"NOT_FOUND\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    void updateStatus(@RequestBody UpdateUserStatusRequest UpdateUserStatusRequest, @PathVariable Long userId);
}
