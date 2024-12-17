package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.Dia;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
}
