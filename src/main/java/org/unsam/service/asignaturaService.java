package org.unsam.service;

import org.unsam.entity.asignatura;
import org.unsam.entity.aula;

import java.util.List;
import java.util.Optional;

public interface asignaturaService {
    List<asignatura> listarAsignaturas();
    Optional<asignatura> obtenerAsignaturaPorId(Long id);
    asignatura guardarAsignatura(asignatura asignatura);
    Optional<asignatura> actualizarAsignatura(Long id, asignatura asignatura);
    boolean eliminarAsignatura(Long id);

    List<aula> obtenerAulasPorNombre(String nombre);
}