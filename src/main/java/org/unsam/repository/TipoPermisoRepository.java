package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.TipoPermiso;

@Repository
public interface TipoPermisoRepository extends JpaRepository<TipoPermiso, Long> {
}