package org.unsam.service;

import org.unsam.entity.Carrera;
import java.util.List;
import java.util.Optional;

public interface CarreraService {
    List<Carrera> listarCarreras();
    Optional<Carrera> obtenerCarreraPorId(Long id);
    Carrera guardarCarrera(Carrera carrera);
    Optional<Carrera> actualizarCarrera(Long id, Carrera carrera);
    boolean eliminarCarrera(Long id);
}