package com.gestion.personas_api.service;

import com.gestion.personas_api.model.Persona;
import com.gestion.personas_api.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    public Persona crearPersona(String nombre, int edad) {
        Persona nueva = new Persona(nombre, edad);
        return personaRepository.save(nueva);
    }

}
