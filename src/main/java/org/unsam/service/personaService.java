package org.unsam.service;

import org.unsam.entity.persona;

import java.util.List;
import java.util.Optional;

public interface personaService {
    persona guardarPersona(persona persona);
    List<persona> listarPersonas();
    Optional<persona> obtenerPersona(Long id);
}
