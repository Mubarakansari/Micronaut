package com.lynkersoft.utils;

import io.micronaut.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {
        private HttpStatus httpStatus;
        private String Message;
        private Object feed;
}
