package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.Horario;
import org.unsam.service.HorarioService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public ResponseEntity<List<Horario>> listarHorarios() {
        return ResponseEntity.ok(horarioService.listarHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtenerHorarioPorId(@PathVariable Long id) {
        return horarioService.obtenerHorarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Horario> crearHorario(@RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.guardarHorario(horario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long id, @RequestBody Horario horario) {
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