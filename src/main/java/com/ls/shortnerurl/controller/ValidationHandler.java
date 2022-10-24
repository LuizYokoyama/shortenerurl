package com.ls.shortnerurl.controller;

import com.ls.shortnerurl.exceptions.UrlNotFoundRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UrlNotFoundRuntimeException.class})
    protected ResponseEntity<Object> UrlNotFound(
            UrlNotFoundRuntimeException ex ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
