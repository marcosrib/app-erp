package br.com.somar.app.users.adapters.inbound.controllers.swagger.api;

import br.com.somar.app.common.exceptions.handler.ErrorResponse;
import br.com.somar.app.users.adapters.inbound.controllers.requests.UserFilterRequest;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.PageResponse;
import br.com.somar.app.users.adapters.inbound.controllers.responses.users.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
@Tag(name = "Usuário API")
public interface UserApi {
    @Operation(summary = "Listar usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    public PageResponse<UserResponse> index(UserFilterRequest filter, Pageable pageable) throws Exception;
}
