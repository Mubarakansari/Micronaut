package com.lynkersoft.exception;

public class GenericException extends RuntimeException {
    public GenericException(NotFount message) {
        super(message.getErrorMessage());
    }
}
