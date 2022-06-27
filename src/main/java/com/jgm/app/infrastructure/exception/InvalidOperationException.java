package com.jgm.app.infrastructure.exception;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException(String operation) {
        super(String.format("Binary operation not allowed! : [ %s ]", operation));
    }

}
