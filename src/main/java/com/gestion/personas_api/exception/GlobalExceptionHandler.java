package com.gestion.personas_api.exception;

import com.gestion.personas_api.dto.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Es una clase que escucha errores que ocurren en cualquier controller y decide qué responder.
// -No es un controller común.
// -No tiene endpoints (@GetMapping, etc).
// -No recibe requests normales.

@RestControllerAdvice // -> “Esta clase escucha excepciones de TODOS los controllers”
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) // “Cuando ocurra una MethodArgumentNotValidException, ejecutá el método de abajo”. Es como un catch, pero global.
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
    // ResponseEntity<ApiError> → la respuesta HTTP que vos decidís devolver
    // ex → es la excepción que Spring lanzó

    /*Qué hace ese método
     -Spring detecta el error
     -Spring le pasa el error al handler (método).
     -El metodo:
     -lee los mensajes ("El nombre es obligatorio")
     -los mete en un ApiError
     -decide devolver 400 + JSON
     -📌 El handler decide la forma de la respuesta. */

        Map<String, String> errores = new HashMap<>();
        /* Vamos a guardar errores por campo
         Ejemplo:
        "nombre" → "El nombre es obligatorio"
        "edad" → "La edad no puede ser negativa"*/
        ex.getBindingResult().getFieldErrors().forEach(err ->
                errores.put(err.getField(), err.getDefaultMessage())
        );

        /*  ex.getBindingResult().getFieldErrors()
         ex → es el error que lanzó Spring
        getBindingResult() → contiene info de validaciones
        getFieldErrors() → lista de errores por campo
        👉 Acá ya están los mensajes que vos pusiste en el DTO osea PersonaRequest.java @NotBlank(message = "...")*/

        /*.forEach(err ->
        errores.put(err.getField(), err.getDefaultMessage()));
        Por cada error:
        err.getField() → nombre del campo (nombre, edad)
        err.getDefaultMessage() → mensaje que vos escribiste
        👉 Lo guardamos en el Map.
         */


        ApiError body = new ApiError("Validación fallida", errores);
        return ResponseEntity.badRequest().body(body);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex) {
        ApiError body = new ApiError(ex.getMessage(), null); // “Creo un objeto ApiError”, Le paso el mensaje del error, Y como no hay errores de validación, paso null.
        return ResponseEntity.status(404).body(body); //Devuelvo una respuesta HTTP, Devuelvo una respuesta HTTP, Y con ese objeto como JSON.
    }


}
