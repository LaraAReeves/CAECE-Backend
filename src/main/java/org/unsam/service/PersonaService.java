package org.unsam.service;

import org.unsam.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona guardarPersona(Persona persona);
    List<Persona> listarPersonas();
    Optional<Persona> obtenerPersona(Long id);
    Optional<Persona> obtenerPersonaPorId(Long id);
    Optional<Persona> actualizarPersona(Long id, Persona personaActualizada);
    boolean eliminarPersona(Long id);

    Optional<Persona> obtenerPersonaPorUsername(String username);
    String hashPassword(String password);
    boolean verificarPassword(String passwordIngresada, String passwordHasheada);
    
}
