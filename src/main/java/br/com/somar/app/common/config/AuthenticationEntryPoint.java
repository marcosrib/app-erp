package br.com.somar.app.common.config;

import br.com.somar.app.common.exceptions.handler.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
       ErrorResponse errorResponse = ErrorResponse.builder()
               .message("Não Autorizado")
                .status(HttpServletResponse.SC_UNAUTHORIZED)
               .timestamp(LocalDateTime.now())
                .error_code("UNAUTHORIZED");
        response.getWriter().write(convertObjectToJson(errorResponse));

    }
    private String convertObjectToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper.writeValueAsString(object);
    }

}
