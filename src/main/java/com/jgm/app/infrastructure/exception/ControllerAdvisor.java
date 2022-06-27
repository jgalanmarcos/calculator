package com.jgm.app.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<String> exception(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<String> invalidOperationException(InvalidOperationException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(e.getMessage(), httpStatus);
    }

}
