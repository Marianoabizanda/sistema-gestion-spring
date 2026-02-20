package com.gestion.personas_api.exception;

public class NotFoundException extends RuntimeException {
    // Error cuando no existe la persona.
    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}
