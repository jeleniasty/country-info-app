package com.jeleniasty.countryinfoapp.controller;

import com.jeleniasty.countryinfoapp.exception.ExceptionResponse;
import com.jeleniasty.countryinfoapp.exception.NoInformationFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoInformationFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(NoInformationFoundException exception) {
        return new ResponseEntity<>(new ExceptionResponse("No information found!"),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> constraintViolationExceptionHandler(ConstraintViolationException exception) {
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
