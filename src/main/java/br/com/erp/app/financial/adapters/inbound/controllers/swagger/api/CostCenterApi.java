package br.com.erp.app.financial.adapters.inbound.controllers.swagger.api;

import br.com.erp.app.common.exceptions.handler.ErrorResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.requests.CostCenterRequest;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.CostCenterResponse;
import br.com.erp.app.financial.adapters.inbound.controllers.responses.PageFinancialResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Tag(name = "Centro de custo API")
public interface CostCenterApi {
    @Operation(summary = "Cadastra centro de custo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "401", description = "Unauthorized.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Unauthorized.\",\"status\":401,\"error_code\":\"UNAUTHORIZED\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    void create(@RequestBody CostCenterRequest costCenterRequest);
    @Operation(summary = "Atualiza centro de custo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404", description = "Resource not found.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Resource not found.\",\"status\":404,\"error_code\":\"NOT_FOUND\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "401", description = "Unauthorized.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Unauthorized.\",\"status\":401,\"error_code\":\"UNAUTHORIZED\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    void update(@RequestBody CostCenterRequest costCenterRequest, @Parameter(description = "Id cost center")  @PathVariable Integer id);
    @Operation(summary = "Lista centro de custo paginado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
                @ApiResponse(responseCode = "401", description = "Unauthorized.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Unauthorized.\",\"status\":401,\"error_code\":\"UNAUTHORIZED\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    PageFinancialResponse<CostCenterResponse> findPagination(@Parameter(description = "Name cost center", required = false) @RequestParam(required = false) String name, Pageable pageable);

    @Operation(summary = "Lista todos os centros de custo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Unauthorized.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Unauthorized.\",\"status\":401,\"error_code\":\"UNAUTHORIZED\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{\"message\":\"Internal server error\",\"status\":500,\"error_code\":\"INTERNAL_ERROR\",\"timestamp\":\"2023-09-27T21:44:33Z\"}"))),
    })
    List<CostCenterResponse> index();
}
