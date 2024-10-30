package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.persona;
import org.unsam.repository.personaRepository;
import org.unsam.service.personaService;

import java.util.List;
import java.util.Optional;

@Service
public class personaServiceImpl implements personaService {

    @Autowired
    private personaRepository personaRepository;

    @Override
    public persona guardarPersona(persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<persona> obtenerPersona(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Optional<persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Optional<persona> actualizarPersona(Long id, persona personaActualizada) {
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
}