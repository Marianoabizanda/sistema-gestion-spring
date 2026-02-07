package com.gestion.personas_api.repository;

import com.gestion.personas_api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

// “Spring, dame un repositorio que sepa guardar, buscar, listar y borrar Personas”
public interface PersonaRepository extends JpaRepository<Persona, Long> {
//“Creame automáticamente un repositorio completo para la entidad Persona, cuyo ID es Long”

    //JpaRepository ya trae métodos listos como:

    // -findAll() → trae todo

    // -save() → guarda

    // -findById() → busca por id

    // -deleteById() → borra

}