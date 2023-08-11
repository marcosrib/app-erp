package br.com.somar.app.exceptions.handler;

import br.com.somar.app.exceptions.ResourceAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException() {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .message("Internal server error")
                .status(status)
                .error_code("INTERNAL_ERROR")
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> resourceAlreadyExists(Exception ex) {
        int status = HttpStatus.CONFLICT.value();
        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .message(ex.getLocalizedMessage())
                .status(status)
                .error_code("CONFLICT")
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(status));
    }
}
