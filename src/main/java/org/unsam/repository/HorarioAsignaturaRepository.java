package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.HorarioAsignatura;

@Repository
public interface HorarioAsignaturaRepository extends JpaRepository<HorarioAsignatura, Long> {
}
