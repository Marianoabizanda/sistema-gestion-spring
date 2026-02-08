package com.gestion.personas_api.dto;

import java.util.Map;

public class ApiError {

    private String mensaje;
    private Map<String, String> errores;

    public ApiError(String mensaje, Map<String, String> errores) {
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Map<String, String> getErrores() {
        return errores;
    }
}
