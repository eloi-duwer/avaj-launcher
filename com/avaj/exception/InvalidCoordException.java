package com.avaj.exception;

import java.lang.Exception;

public class InvalidCoordException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidCoordException() {
        super("Coordinate is in invalid Range");
    }

    public InvalidCoordException(String e) {
        super(e);
    }

    public InvalidCoordException(String e, Throwable cause) {
        super(e, cause);
    }
}