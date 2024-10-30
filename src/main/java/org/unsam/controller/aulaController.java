package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.aula;
import org.unsam.service.aulaService;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class aulaController {

    @Autowired
    private aulaService aulaService;

    @GetMapping
    public ResponseEntity<List<aula>> listarAulas() {
        return ResponseEntity.ok(aulaService.listarAulas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<aula> obtenerAulaPorId(@PathVariable Long id) {
        return aulaService.obtenerAulaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<aula> crearAula(@RequestBody aula aula) {
        return ResponseEntity.ok(aulaService.guardarAula(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<aula> actualizarAula(@PathVariable Long id, @RequestBody aula aula) {
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