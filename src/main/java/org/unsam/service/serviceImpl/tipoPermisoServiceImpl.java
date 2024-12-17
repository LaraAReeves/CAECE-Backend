package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.TipoPermiso;
import org.unsam.repository.TipoPermisoRepository;
import org.unsam.service.TipoPermisoService;
import java.util.List;
import java.util.Optional;

@Service
public class TipoPermisoServiceImpl implements TipoPermisoService {
    @Autowired
    private TipoPermisoRepository tipoPermisoRepository;

    @Override
    public List<TipoPermiso> listarTiposPermiso() {
        return tipoPermisoRepository.findAll();
    }

    @Override
    public Optional<TipoPermiso> obtenerTipoPermisoPorId(Long id) {
        return tipoPermisoRepository.findById(id);
    }

    @Override
    public TipoPermiso guardarTipoPermiso(TipoPermiso tipoPermiso) {
        return tipoPermisoRepository.save(tipoPermiso);
    }

    @Override
    public Optional<TipoPermiso> actualizarTipoPermiso(Long id, TipoPermiso tipoPermiso) {
        Optional<TipoPermiso> tipoPermisoOptional = obtenerTipoPermisoPorId(id);
        if (tipoPermisoOptional.isPresent()) {
            TipoPermiso tipoPermisoToUpdate = tipoPermisoOptional.get();
            tipoPermisoToUpdate.setNombre(tipoPermiso.getNombre());
            return Optional.of(guardarTipoPermiso(tipoPermisoToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarTipoPermiso(Long id) {
        Optional<TipoPermiso> tipoPermisoOptional = obtenerTipoPermisoPorId(id);
        if (tipoPermisoOptional.isPresent()) {
            tipoPermisoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

 */
