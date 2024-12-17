package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.ProfesorAsignatura;
import java.util.List;

@Repository
public interface ProfesorAsignaturaRepository extends JpaRepository<ProfesorAsignatura, Long> {
    List<ProfesorAsignatura> findByPersonaId(Long profesorId);
    List<ProfesorAsignatura> findByAsignaturaId(Long asignaturaId);
    boolean existsByPersonaIdAndAsignaturaId(Long profesorId, Long asignaturaId);
}