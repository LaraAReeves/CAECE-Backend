package org.unsam.service;

import org.unsam.entity.Asignatura;
import org.unsam.entity.Aula;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {
    List<Asignatura> listarAsignaturas();
    Optional<Asignatura> obtenerAsignaturaPorId(Long id);
    Asignatura guardarAsignatura(Asignatura asignatura);
    Optional<Asignatura> actualizarAsignatura(Long id, Asignatura asignatura);
    boolean eliminarAsignatura(Long id);

    List<Aula> obtenerAulasPorNombre(String nombre);
}