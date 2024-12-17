/*
package org.unsam.service.serviceImpl;


import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.Horario;
import org.unsam.repository.HorarioRepository;
import org.unsam.service.HorarioService;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Optional<Horario> obtenerHorarioPorId(Long id) {
        return horarioRepository.findById(id);
    }

    @Override
    public Horario guardarHorario(Horario nuevoHorario) {
        if (hayConflictoHorario(nuevoHorario.getAulaId(), nuevoHorario.getHoraInicio(), nuevoHorario.getHoraFin())) {
            throw new IllegalArgumentException("Conflicto de horario: ya existe una clase en esta aula durante este tiempo.");
        }
        return horarioRepository.save(nuevoHorario);
    }

    @Override
    public Optional<Horario> actualizarHorario(Long id, Horario horarioActualizado) {
        return horarioRepository.findById(id)
                .map(horario -> {
                    horario.setDia(horarioActualizado.getDia());
                    horario.setHoraInicio(horarioActualizado.getHoraInicio());
                    horario.setHoraFin(horarioActualizado.getHoraFin());
                    horario.setAulaId(horarioActualizado.getAulaId());
                    horario.setAsignaturaId(horarioActualizado.getAsignaturaId());
                    return horarioRepository.save(horario);
                });
    }

    @Override
    public boolean eliminarHorario(Long id) {
        try {
            horarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean hayConflictoHorario(Long aulaId, LocalTime horaInicio, LocalTime horaFin) {
    List<Horario> horariosExistentes = horarioRepository.findAll();
    
    return horariosExistentes.stream()
        .filter(h -> h.getAulaId().equals(aulaId))
        .anyMatch(h -> (h.getHoraInicio().isBefore(horaFin) && horaInicio.isBefore(h.getHoraFin())));
    }
}

 */