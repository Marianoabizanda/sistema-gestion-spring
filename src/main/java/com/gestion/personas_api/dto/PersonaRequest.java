package com.gestion.personas_api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// ESTO ES UN DTO - DATOS QUE VIAJAN.

// Esto es como una "cajita" para recibir el JSON del cliente
public class PersonaRequest {
    // Atributos

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 120, message = "La edad no puede ser mayor a 120")
    private int edad;


    // Constructor vacio
    public PersonaRequest() {
    }


    // Métodos

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
