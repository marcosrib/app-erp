package br.com.somar.app.users.adapters.inbound.controllers.responses.users;

import br.com.somar.app.users.application.core.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record PageResponse<T>(
        List<T> data,
        int totalPages,
        long totalElements
) {
}
