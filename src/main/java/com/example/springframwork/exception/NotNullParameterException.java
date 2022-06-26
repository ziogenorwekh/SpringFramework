package com.example.springframwork.exception;

public class NotNullParameterException extends RuntimeException {
    public NotNullParameterException() {
    }

    public NotNullParameterException(Throwable cause) {
        super(cause);
    }
}
