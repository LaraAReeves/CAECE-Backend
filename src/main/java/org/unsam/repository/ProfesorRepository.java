package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
