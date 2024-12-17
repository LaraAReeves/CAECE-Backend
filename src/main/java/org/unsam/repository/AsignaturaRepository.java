package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unsam.entity.Asignatura;

import java.util.Optional;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    @Query("SELECT a FROM asignatura a WHERE LOWER(a.nombre) = LOWER(:nombre)")
    Optional<Asignatura> findByNombreIgnoreCase(@Param("nombre") String nombre);
}