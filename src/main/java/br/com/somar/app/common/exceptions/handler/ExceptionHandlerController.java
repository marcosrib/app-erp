package br.com.somar.app.common.exceptions.handler;

import br.com.somar.app.common.exceptions.ResourceAlreadyExistsException;
import br.com.somar.app.common.exceptions.ResourceNotFoundException;
import br.com.somar.app.common.exceptions.UnauthorizedException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ExceptionHandlerController {


    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(java.lang.Exception ex, WebRequest request) {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Internal server error")
                .status(status)
                .error_code("INTERNAL_ERROR")
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> unauthorizedException(java.lang.Exception ex, WebRequest request) {
        int status = HttpStatus.UNAUTHORIZED.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message(ex.getLocalizedMessage()))
                .status(status)
                .error_code("UNAUTHORIZED")
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> accessDeniedException(java.lang.Exception ex, WebRequest request) {
        int status = HttpStatus.UNAUTHORIZED.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Não Autorizado")
                .status(status)
                .error_code("UNAUTHORIZED")
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
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFound(Exception ex) {
        int status = HttpStatus.NOT_FOUND.value();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message(ex.getLocalizedMessage()))
                .status(status)
                .error_code("NOT_FOUND")
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        BindingResult bindingResult = ex.getBindingResult();


        HashMap<String, String> hashErrors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            hashErrors.put("message", error.getDefaultMessage());
        });
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Validation Error")
                .status(status)
                .error_code("BAD_REQUEST")
                .errors(hashErrors)
                .timestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    private String message(String code, Object... params) {
        return messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
    }
}
