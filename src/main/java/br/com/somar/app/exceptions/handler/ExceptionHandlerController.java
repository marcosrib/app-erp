package br.com.somar.app.exceptions.handler;

import br.com.somar.app.exceptions.ResourceAlreadyExistsException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {


    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Internal server error")
                .status(status)
                .error_code("INTERNAL_ERROR")
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> unauthorizedException(Exception ex, WebRequest request) {
        int status = HttpStatus.UNAUTHORIZED.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Internal server error")
                .status(status)
                .error_code("INTERNAL_ERROR")
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> resourceAlreadyExists(Exception ex) {
        int status = HttpStatus.CONFLICT.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message(ex.getLocalizedMessage()))
                .status(status)
                .error_code("CONFLICT")
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }

    private String message(String code, Object... params) {
        return messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
    }
}
