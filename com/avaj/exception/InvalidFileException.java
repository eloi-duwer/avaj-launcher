package com.avaj.exception;

import java.lang.Exception;

public class InvalidFileException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidFileException() {
        super("Invalid file");
    }

    public InvalidFileException(String e) {
        super(e);
    }

    public InvalidFileException(String e, Throwable reason) {
        super(e, reason);
    }

}