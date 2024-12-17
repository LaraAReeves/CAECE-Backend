package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.ProfesorAsignatura;
import org.unsam.service.ProfesorAsignaturaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/profesor-asignatura")
public class ProfesorAsignaturaController {

    @Autowired
    private ProfesorAsignaturaService profesorAsignaturaService;

    @GetMapping
    public ResponseEntity<List<ProfesorAsignatura>> listarTodos() {
        return ResponseEntity.ok(profesorAsignaturaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorAsignatura> getById(@PathVariable Long id) {
        return ResponseEntity.ok(profesorAsignaturaService.obtenerPorId(id).orElseThrow(() -> new NoSuchElementException("El profesorAsignatura con id " + id + " no existe"))
        );
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<ProfesorAsignatura>> obtenerPorProfesorId(@PathVariable Long profesorId) {
        return ResponseEntity.ok(profesorAsignaturaService.obtenerPorProfesorId(profesorId));
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<ProfesorAsignatura>> obtenerPorAsignaturaId(@PathVariable Long asignaturaId) {
        return ResponseEntity.ok(profesorAsignaturaService.obtenerPorAsignaturaId(asignaturaId));
    }

    @PostMapping
    public ResponseEntity<ProfesorAsignatura> asignarProfesorAAsignatura(@RequestBody ProfesorAsignatura profesorAsignatura) {
        return ResponseEntity.ok(profesorAsignaturaService.asignarProfesorAAsignatura(profesorAsignatura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorAsignatura> actualizarAsignacion(@PathVariable Long id, @RequestBody ProfesorAsignatura profesorAsignatura) {
        return ResponseEntity.ok(profesorAsignaturaService.actualizarAsignacion(id, profesorAsignatura).orElseThrow(() -> new NoSuchElementException("No se pudo actualizar la asignación. El profesorAsignatura con id " + id + " no existe."))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Long id) {
        profesorAsignaturaService.eliminarAsignacion(id);
        return ResponseEntity.noContent().build();
    }
}