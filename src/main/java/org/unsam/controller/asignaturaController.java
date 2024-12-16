package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.service.asignaturaService;
import org.unsam.entity.aula;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class asignaturaController {

    @Autowired
    private asignaturaService asignaturaService;

    @GetMapping("/aulas/{nombre}")
    public ResponseEntity<List<aula>> obtenerAulasPorCodigo(@PathVariable String nombre) {
        List<aula> aulas = asignaturaService.obtenerAulasPorNombre(nombre);

        if (aulas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(aulas);
    }
}