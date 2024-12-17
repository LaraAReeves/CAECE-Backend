package org.unsam.service;

import org.unsam.entity.TipoPermiso;
 import java.util.List;
import java.util.Optional;

public interface TipoPermisoService {
    List<TipoPermiso> listarTiposPermiso();
    Optional<TipoPermiso> obtenerTipoPermisoPorId(Long id);
    TipoPermiso guardarTipoPermiso(TipoPermiso tipoPermiso);
    Optional<TipoPermiso> actualizarTipoPermiso(Long id, TipoPermiso tipoPermiso);
    boolean eliminarTipoPermiso(Long id);
}
