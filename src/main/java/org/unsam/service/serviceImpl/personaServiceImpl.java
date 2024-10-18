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
        return Optional.empty();
    }

    @Override
    public Optional<persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }
}
