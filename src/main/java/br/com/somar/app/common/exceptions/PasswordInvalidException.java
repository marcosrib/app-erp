package br.com.somar.app.common.exceptions;

import org.springframework.http.HttpStatus;

public class PasswordInvalidException extends RuntimeException{
    public PasswordInvalidException(String message) {
        super(message);
    }
}
