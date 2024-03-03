package com.onlysystems.negocio.exepcion;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}