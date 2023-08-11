package br.com.somar.app.exceptions.handler;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private int status;
    private String error_code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime timestamp;

    private ErrorResponse(Builder builder) {
        this.message = builder.message;
        this.status = builder.status;
        this.error_code = builder.error_code;
        this.timestamp = builder.timestamp;
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

    // Builder class

    public static class Builder {
        private String message;
        private int status;
        private String error_code;
        private LocalDateTime timestamp;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder error_code(String error_code) {
            this.error_code = error_code;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }
}
