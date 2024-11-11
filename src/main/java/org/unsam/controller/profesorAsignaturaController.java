package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.profesorAsignatura;
import org.unsam.service.profesorAsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/profesor-asignatura")
public class profesorAsignaturaController {

    @Autowired
    private profesorAsignaturaService profesorAsignaturaService;

    @GetMapping
    public ResponseEntity<List<profesorAsignatura>> listarTodos() {
        return ResponseEntity.ok(profesorAsignaturaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<profesorAsignatura> getById(@PathVariable Long id) {
        return ResponseEntity.ok(profesorAsignaturaService.obtenerPorId(id).orElseThrow());
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<profesorAsignatura>> obtenerPorProfesorId(@PathVariable Long profesorId) {
        return ResponseEntity.ok(profesorAsignaturaService.obtenerPorProfesorId(profesorId));
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<profesorAsignatura>> obtenerPorAsignaturaId(@PathVariable Long asignaturaId) {
        return ResponseEntity.ok(profesorAsignaturaService.obtenerPorAsignaturaId(asignaturaId));
    }

    @PostMapping
    public ResponseEntity<profesorAsignatura> asignarProfesorAAsignatura(@RequestBody profesorAsignatura profesorAsignatura) {
        return ResponseEntity.ok(profesorAsignaturaService.asignarProfesorAAsignatura(profesorAsignatura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<profesorAsignatura> actualizarAsignacion(@PathVariable Long id, @RequestBody profesorAsignatura profesorAsignatura) {
        return ResponseEntity.ok(profesorAsignaturaService.actualizarAsignacion(id, profesorAsignatura).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Long id) {
        profesorAsignaturaService.eliminarAsignacion(id);
        return ResponseEntity.noContent().build();
    }
}