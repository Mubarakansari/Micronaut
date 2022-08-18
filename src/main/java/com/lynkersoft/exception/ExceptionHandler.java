package com.lynkersoft.exception;


import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Singleton;


@Singleton
@Requires(classes = {GenericException.class, ExceptionHandler.class})
public class ExceptionHandler implements io.micronaut.http.server.exceptions.ExceptionHandler<GenericException, HttpResponse<ErrorMessage>> {
    @Override
    public HttpResponse<ErrorMessage> handle(HttpRequest request, GenericException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(exception.getLocalizedMessage());
        errorMessage.setHttpStatus(HttpStatus.NOT_FOUND);
        return HttpResponse.serverError(errorMessage);
    }
}
