package com.roland.oroz.h2crud.exception;

public class InternalServerError extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public InternalServerError(String message) {
        super(message);
    }
    public InternalServerError(String message, Throwable throwable) {
        super(message, throwable);
    }
}
