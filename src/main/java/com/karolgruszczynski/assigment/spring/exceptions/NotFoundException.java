package com.karolgruszczynski.assigment.spring.exceptions;

import org.springframework.http.HttpStatus;


public class NotFoundException extends RuntimeException {
    private HttpStatus status;
    private String errorMessage;

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public NotFoundException(String message, HttpStatus status, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
