package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.asignatura;
import org.unsam.entity.aula;
import org.unsam.entity.horario;
import org.unsam.repository.asignaturaRepository;
import org.unsam.service.asignaturaService;
import org.unsam.repository.horarioRepository;
import org.unsam.repository.aulaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class asignaturaServiceImpl implements asignaturaService {
    @Autowired
    private asignaturaRepository asignaturaRepository;

    @Autowired
    private horarioRepository horarioRepository;

    @Autowired
    private aulaRepository aulaRepository;

    @Override
    public List<asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Optional<asignatura> obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public asignatura guardarAsignatura(asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Optional<asignatura> actualizarAsignatura(Long id, asignatura asignatura) {
        Optional<asignatura> asignaturaOptional = obtenerAsignaturaPorId(id);
        if (asignaturaOptional.isPresent()) {
            asignatura asignaturaToUpdate = asignaturaOptional.get();
            asignaturaToUpdate.setNombre(asignatura.getNombre());
            asignaturaToUpdate.setCarreraId(asignatura.getCarreraId());
            return Optional.of(guardarAsignatura(asignaturaToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarAsignatura(Long id) {
        Optional<asignatura> asignaturaOptional = obtenerAsignaturaPorId(id);
        if (asignaturaOptional.isPresent()) {
            asignaturaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<aula> obtenerAulasPorNombre(String nombre) {
        Optional<asignatura> asignaturaOpt = asignaturaRepository.findByNombreIgnoreCase(nombre);

        if (asignaturaOpt.isPresent()) {
            asignatura asignatura = asignaturaOpt.get();
            List<horario> horarios = horarioRepository.findByAsignaturaId(asignatura.getId());

            return horarios.stream()
                    .map(horario -> aulaRepository.findById(horario.getAulaId()).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList(); // Retorna una lista vacía si no se encuentra la asignatura
    }
}