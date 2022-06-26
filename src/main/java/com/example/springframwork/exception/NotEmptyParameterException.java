package com.example.springframwork.exception;

public class NotEmptyParameterException extends RuntimeException {
    public NotEmptyParameterException() {
    }

    public NotEmptyParameterException(Throwable cause) {
        super(cause);
    }
}
