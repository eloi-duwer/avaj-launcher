package com.avaj.exception;

import java.lang.Exception;

public class InvalidWeatherTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidWeatherTypeException() {
        super("Invalid weather type");
    }

    public InvalidWeatherTypeException(String e) {
        super(e);
    }

    public InvalidWeatherTypeException(String e, Throwable reason) {
        super(e, reason);
    }

}