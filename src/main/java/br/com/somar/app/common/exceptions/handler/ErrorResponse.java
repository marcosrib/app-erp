package br.com.somar.app.common.exceptions.handler;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ErrorResponse {
    private String message;
    private int status;
    private String error_code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HashMap errors;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime timestamp;

    private ErrorResponse() {
    }

    // Getters

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getError_code() {
        return error_code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HashMap getErrors() {
        return errors;
    }


// Builder class

    public static ErrorResponse builder() {
        return new ErrorResponse();
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponse error_code(String error_code) {
        this.error_code = error_code;
        return this;
    }
      public ErrorResponse timestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    public ErrorResponse errors(HashMap errors) {
        this.errors = errors;
        return this;
    }
}
