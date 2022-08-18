package com.lynkersoft.exception;

import lombok.Getter;

@Getter
public enum NotFount {
    USER_ID_NOT_FOUND("User id not found");

    private final String errorMessage;

    NotFount(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
