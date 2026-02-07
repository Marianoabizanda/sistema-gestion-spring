package com.gestion.personas_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // -> Esta clase representa una tabla.
public class Persona {

    @Id // -> Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue -> La DB genera el ID
    private Long id;//Atributos

    private String nombre;
    private int edad;


    public Persona() {
        // constructor vacío obligatorio para JPA
    }


    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
