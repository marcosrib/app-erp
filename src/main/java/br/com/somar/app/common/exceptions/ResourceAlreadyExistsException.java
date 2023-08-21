package br.com.somar.app.common.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
