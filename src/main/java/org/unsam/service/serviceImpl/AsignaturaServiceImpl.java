package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.Asignatura;
import org.unsam.entity.Aula;
import org.unsam.entity.Horario;
import org.unsam.repository.AsignaturaRepository;
import org.unsam.service.AsignaturaService;
import org.unsam.repository.HorarioRepository;
import org.unsam.repository.AulaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    /*
    @Autowired
    private HorarioRepository horarioRepository;
     */

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Optional<Asignatura> obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Optional<Asignatura> actualizarAsignatura(Long id, Asignatura asignatura) {
        Optional<Asignatura> asignaturaOptional = obtenerAsignaturaPorId(id);
        if (asignaturaOptional.isPresent()) {
            Asignatura asignaturaToUpdate = asignaturaOptional.get();
            asignaturaToUpdate.setNombre(asignatura.getNombre());
            //asignaturaToUpdate.setCarreraId(asignatura.getCarreraId());
            return Optional.of(guardarAsignatura(asignaturaToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarAsignatura(Long id) {
        Optional<Asignatura> asignaturaOptional = obtenerAsignaturaPorId(id);
        if (asignaturaOptional.isPresent()) {
            asignaturaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Aula> obtenerAulasPorNombre(String nombre) {
        Optional<Asignatura> asignaturaOpt = asignaturaRepository.findByNombreIgnoreCase(nombre);

        if (asignaturaOpt.isPresent()) {
            Asignatura asignatura = asignaturaOpt.get();
            List<Horario> horarios = horarioRepository.findByAsignaturaId(asignatura.getId());

            return horarios.stream()
                    .map(horario -> aulaRepository.findById(horario.getAulaId()).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList(); // Retorna una lista vacía si no se encuentra la asignatura
    }
}