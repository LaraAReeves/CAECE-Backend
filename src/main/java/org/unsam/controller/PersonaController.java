package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.unsam.entity.Persona;
import org.unsam.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping(value = "/usuarioPOST")
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.guardarPersona(persona);
        return ResponseEntity.ok(nuevaPersona);
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listarPersonas() {
        List<Persona> personas = personaService.listarPersonas();
        return ResponseEntity.ok(personas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.obtenerPersonaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.guardarPersona(persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.actualizarPersona(id, persona)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        if (personaService.eliminarPersona(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
