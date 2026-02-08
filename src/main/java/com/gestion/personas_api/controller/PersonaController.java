package com.gestion.personas_api.controller;

import com.gestion.personas_api.model.Persona;
import com.gestion.personas_api.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gestion.personas_api.dto.PersonaRequest;

import jakarta.validation.Valid;




import java.util.List;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) { //Este constructor se llama inyeccion de dependencias "Spring, dame una instancia de PersonaService y yo la uso"
        this.personaService = personaService;                 // Luego no hace falta hacer new PersonaService(), Spring se encarga.
    }

    @GetMapping("/personas")
    public List<Persona> listarPersonas(){
        return personaService.listarPersonas();
    }



    //Si me piden POST /personas con un JSON → ese JSON se convierte en PersonaRequest → con esos datos creo una Persona
    @PostMapping("/personas")
    public Persona crear(@Valid @RequestBody PersonaRequest request) {//@RequestBody es la clave: le dice a Spring “lo que venga en el body (JSON), conviértelo a un objeto Java”.
        return personaService.crearPersona(request.getNombre(), request.getEdad());
    }


}

