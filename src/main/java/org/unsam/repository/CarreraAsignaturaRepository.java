package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.CarreraAsignatura;

@Repository
public interface CarreraAsignaturaRepository extends JpaRepository<CarreraAsignatura, Long> {
}
