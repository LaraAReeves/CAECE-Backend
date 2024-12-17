/*
package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.TipoAula;
import org.unsam.repository.TipoAulaRepository;
import org.unsam.service.TipoAulaService;
import java.util.List;
import java.util.Optional;

@Service
public class TipoAulaServiceImpl implements TipoAulaService {
    @Autowired
    private TipoAulaRepository tipoAulaRepository;

    @Override
    public List<TipoAula> listarTiposAula() {
        return tipoAulaRepository.findAll();
    }

    @Override
    public Optional<TipoAula> obtenerTipoAulaPorId(Long id) {
        return tipoAulaRepository.findById(id);
    }

    @Override
    public TipoAula guardarTipoAula(TipoAula tipoAula) {
        return tipoAulaRepository.save(tipoAula);
    }

    @Override
    public Optional<TipoAula> actualizarTipoAula(Long id, TipoAula tipoAula) {
        Optional<TipoAula> tipoAulaOptional = obtenerTipoAulaPorId(id);
        if (tipoAulaOptional.isPresent()) {
            TipoAula tipoAulaToUpdate = tipoAulaOptional.get();
            tipoAulaToUpdate.setNombre(tipoAula.getNombre());
            return Optional.of(guardarTipoAula(tipoAulaToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarTipoAula(Long id) {
        Optional<TipoAula> tipoAulaOptional = obtenerTipoAulaPorId(id);
        if (tipoAulaOptional.isPresent()) {
            tipoAulaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

 */
