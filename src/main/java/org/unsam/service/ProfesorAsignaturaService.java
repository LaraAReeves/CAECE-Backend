package org.unsam.service;

import org.unsam.entity.ProfesorAsignatura;
import java.util.List;
import java.util.Optional;

public interface ProfesorAsignaturaService {
    List<ProfesorAsignatura> listarTodos();
    Optional<ProfesorAsignatura> obtenerPorId(Long id);
    List<ProfesorAsignatura> obtenerPorProfesorId(Long profesorId);
    List<ProfesorAsignatura> listarProfesoresAsignaturas();
    List<ProfesorAsignatura> obtenerPorAsignaturaId(Long asignaturaId);
    ProfesorAsignatura asignarProfesorAAsignatura(ProfesorAsignatura profesorAsignatura);
    Optional<ProfesorAsignatura> actualizarAsignacion(Long id, ProfesorAsignatura profesorAsignatura);
    boolean eliminarAsignacion(Long id);
    boolean existeAsignacion(Long profesorId, Long asignaturaId);
}