package org.unsam.service;

import org.unsam.entity.Aula;
import java.util.List;
import java.util.Optional;

public interface AulaService {
    List<Aula> listarAulas();
    Optional<Aula> obtenerAulaPorId(Long id);
    Aula guardarAula(Aula aula);
    Optional<Aula> actualizarAula(Long id, Aula aula);
    boolean eliminarAula(Long id);
}