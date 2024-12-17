package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.ProfesorAsignatura;
import org.unsam.repository.ProfesorAsignaturaRepository;
import org.unsam.service.ProfesorAsignaturaService;
import org.unsam.repository.PersonaRepository;
import org.unsam.repository.AsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorAsignaturaServiceImpl implements ProfesorAsignaturaService {

    @Autowired
    private ProfesorAsignaturaRepository profesorAsignaturaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<ProfesorAsignatura> listarTodos() {
        return profesorAsignaturaRepository.findAll();
    }

    @Override
    public Optional<ProfesorAsignatura> obtenerPorId(Long id) {
        return profesorAsignaturaRepository.findById(id);
    }

    @Override
    public List<ProfesorAsignatura> obtenerPorProfesorId(Long profesorId) {
        return profesorAsignaturaRepository.findByPersonaId(profesorId);
    }

    @Override
    public List<ProfesorAsignatura> obtenerPorAsignaturaId(Long asignaturaId) {
        return profesorAsignaturaRepository.findByAsignaturaId(asignaturaId);
    }
    
    @Override
    public List<ProfesorAsignatura> listarProfesoresAsignaturas() {
        return profesorAsignaturaRepository.findAll();
    }

    @Override
    public ProfesorAsignatura asignarProfesorAAsignatura(ProfesorAsignatura profesorAsignatura) {
        // Validar que tanto el profesor como la asignatura existan
        if (!personaRepository.existsById(profesorAsignatura.getProfesorId()) ||
            !asignaturaRepository.existsById(profesorAsignatura.getAsignaturaId())) {
            throw new IllegalArgumentException("El profesor o la asignatura no existen");
        }

        // Validar que no exista ya la asignación
        if (existeAsignacion(profesorAsignatura.getProfesorId(), profesorAsignatura.getAsignaturaId())) {
            throw new IllegalStateException("Esta asignación ya existe");
        }

        return profesorAsignaturaRepository.save(profesorAsignatura);
    }

    @Override
    public Optional<ProfesorAsignatura> actualizarAsignacion(Long id, ProfesorAsignatura profesorAsignatura) {
        return profesorAsignaturaRepository.findById(id)
            .map(asignacionExistente -> {
                // Validar que tanto el profesor como la asignatura existan
                if (!personaRepository.existsById(profesorAsignatura.getProfesorId()) ||
                    !asignaturaRepository.existsById(profesorAsignatura.getAsignaturaId())) {
                    throw new IllegalArgumentException("El profesor o la asignatura no existen");
                }

                asignacionExistente.setProfesorId(profesorAsignatura.getProfesorId());
                asignacionExistente.setAsignaturaId(profesorAsignatura.getAsignaturaId());
                return profesorAsignaturaRepository.save(asignacionExistente);
            });
    }

    @Override
    public boolean eliminarAsignacion(Long id) {
        if (profesorAsignaturaRepository.existsById(id)) {
            profesorAsignaturaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existeAsignacion(Long profesorId, Long asignaturaId) {
        return profesorAsignaturaRepository.existsByPersonaIdAndAsignaturaId(profesorId, asignaturaId);
    }
}