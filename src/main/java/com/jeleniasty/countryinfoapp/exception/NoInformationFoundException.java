package com.jeleniasty.countryinfoapp.exception;

public class NoInformationFoundException extends RuntimeException{
    public NoInformationFoundException(String errorMessage) {
        super(errorMessage);
    }
}
