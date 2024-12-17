package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.service.AsignaturaService;
import org.unsam.entity.Aula;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/aulas/{nombre}")
    public ResponseEntity<List<Aula>> obtenerAulasPorCodigo(@PathVariable String nombre) {
        List<Aula> aulas = asignaturaService.obtenerAulasPorNombre(nombre);

        if (aulas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(aulas);
    }
}