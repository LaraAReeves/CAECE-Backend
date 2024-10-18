package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.unsam.entity.persona;
import org.unsam.service.personaService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class personaController {

    @Autowired
    private personaService personaService;

    @PostMapping(value = "/usuarioPOST")
    public ResponseEntity<persona> guardarPersona(@RequestBody persona persona) {
        persona nuevaPersona = personaService.guardarPersona(persona);
        return ResponseEntity.ok(nuevaPersona);
    }

    @GetMapping
    public ResponseEntity<List<persona>> listarPersonas() {
        List<persona> personas = personaService.listarPersonas();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<persona> obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.obtenerPersonaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
