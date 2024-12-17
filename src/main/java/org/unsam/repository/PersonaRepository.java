package org.unsam.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByUsername(String username);
}