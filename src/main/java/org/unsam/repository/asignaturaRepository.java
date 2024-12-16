package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unsam.entity.asignatura;

import java.util.Optional;

@Repository
public interface asignaturaRepository extends JpaRepository<asignatura, Long> {
    @Query("SELECT a FROM asignatura a WHERE LOWER(a.nombre) = LOWER(:nombre)")
    Optional<asignatura> findByNombreIgnoreCase(@Param("nombre") String nombre);
}