package com.lynkersoft.exception;

import io.micronaut.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
