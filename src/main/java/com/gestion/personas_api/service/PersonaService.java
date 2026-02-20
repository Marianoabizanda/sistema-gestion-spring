package com.gestion.personas_api.service;

import com.gestion.personas_api.model.Persona;
import com.gestion.personas_api.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import com.gestion.personas_api.exception.NotFoundException;

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

        public Persona obtenerPorId(Long id) {
            return personaRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("No existe persona con id " + id));
        /*
        findById(id) Devuelve un Optional<Persona>.

        Un Optional significa:
        “Puede que haya persona, puede que no.”
        orElseThrow() significa:
        “Si dentro del Optional hay algo → devolvelo
        Si está vacío → lanzá una excepción”

        -Y esa excepción después la maneja tu GlobalExceptionHandler.*/
    }

}
