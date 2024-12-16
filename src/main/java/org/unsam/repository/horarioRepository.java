package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.horario;

import java.util.List;

@Repository
public interface horarioRepository extends JpaRepository<horario, Long> {
    List<horario> findByAsignaturaId(Long asignaturaId);
}
