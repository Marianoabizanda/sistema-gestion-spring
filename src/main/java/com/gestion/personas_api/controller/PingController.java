package com.gestion.personas_api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController le dice a Spring “Esta clase recibe requests HTTP y devuelve respuestas directamente (texto o JSON)”
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}