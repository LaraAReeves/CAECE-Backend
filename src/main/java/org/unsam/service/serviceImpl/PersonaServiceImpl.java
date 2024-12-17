package org.unsam.service.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.Persona;
import org.unsam.repository.PersonaRepository;
import org.unsam.service.PersonaService;


import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Optional<Persona> obtenerPersonaPorUsername(String username) {
        return personaRepository.findByUsername(username);
    }
    
    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> obtenerPersona(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Optional<Persona> actualizarPersona(Long id, Persona personaActualizada) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaActualizada.getNombre());
                    persona.setApellido(personaActualizada.getApellido());
                    persona.setEmail(personaActualizada.getEmail());
                    return personaRepository.save(persona);
                });
    }

    @Override
    public boolean eliminarPersona(Long id) {
        try {
            personaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para hashear contraseñas
    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }
    
    // Modificar el método guardarPersona para que hashee la contraseña
    @Override
    public Persona guardarPersona(Persona persona) {
        if (persona.getPassword() != null) {
            persona.setPassword(hashPassword(persona.getPassword()));
        }
        return personaRepository.save(persona);
    }

    // Método para verificar contraseña
    public boolean verificarPassword(String passwordIngresada, String passwordHasheada) {
        String passwordIngresadaHash = hashPassword(passwordIngresada);
        return passwordIngresadaHash.equals(passwordHasheada);
    }
}