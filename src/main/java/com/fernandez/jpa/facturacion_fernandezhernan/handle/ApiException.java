package com.fernandez.jpa.facturacion_fernandezhernan.handle;

public class ApiException extends Exception {
    private String message;

    public ApiException(String message) {
        super(message);
    }
}
