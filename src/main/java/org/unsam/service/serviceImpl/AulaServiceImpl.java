package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.Aula;
import org.unsam.repository.AulaRepository;
import org.unsam.service.AulaService;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public Optional<Aula> obtenerAulaPorId(Long id) {
        return aulaRepository.findById(id);
    }

    @Override
    public Aula guardarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Optional<Aula> actualizarAula(Long id, Aula aulaActualizada) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    aula.setNombre(aulaActualizada.getNombre());
                    //aula.setTipoAulaId(aulaActualizada.getTipoAulaId());
                    aula.setPiso(aulaActualizada.getPiso());
                    return aulaRepository.save(aula);
                });
    }

    @Override
    public boolean eliminarAula(Long id) {
        try {
            aulaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
