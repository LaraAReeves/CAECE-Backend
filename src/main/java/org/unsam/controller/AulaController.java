package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.Aula;
import org.unsam.service.AulaService;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public ResponseEntity<List<Aula>> listarAulas() {
        return ResponseEntity.ok(aulaService.listarAulas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> obtenerAulaPorId(@PathVariable Long id) {
        return aulaService.obtenerAulaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aula> crearAula(@RequestBody Aula aula) {
        return ResponseEntity.ok(aulaService.guardarAula(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> actualizarAula(@PathVariable Long id, @RequestBody Aula aula) {
        return aulaService.actualizarAula(id, aula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAula(@PathVariable Long id) {
        if (aulaService.eliminarAula(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}