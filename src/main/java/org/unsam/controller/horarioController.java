package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.horario;
import org.unsam.service.horarioService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class horarioController {

    @Autowired
    private horarioService horarioService;

    @GetMapping
    public ResponseEntity<List<horario>> listarHorarios() {
        return ResponseEntity.ok(horarioService.listarHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<horario> obtenerHorarioPorId(@PathVariable Long id) {
        return horarioService.obtenerHorarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<horario> crearHorario(@RequestBody horario horario) {
        return ResponseEntity.ok(horarioService.guardarHorario(horario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<horario> actualizarHorario(@PathVariable Long id, @RequestBody horario horario) {
        return horarioService.actualizarHorario(id, horario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long id) {
        if (horarioService.eliminarHorario(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}