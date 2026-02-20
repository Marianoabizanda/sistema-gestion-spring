package com.gestion.personas_api.dto;

import java.util.Map;

//creamos una clase Java que represente una forma de respuesta. “Un objeto que describe cómo se ve un error en mi API”

/*
Ejemplo:
{
"mensaje": "Validación fallida",
"errores": {
"nombre": "El nombre es obligatorio"
}
}*/
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
