package com.gestion.personas_api.dto;
import com.gestion.personas_api.dto.PersonaRequest;

// Esto es como una "cajita" para recibir el JSON del cliente
public class PersonaRequest {
    private String nombre;
    private int edad;

    public PersonaRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
