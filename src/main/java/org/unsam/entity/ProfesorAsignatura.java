package org.unsam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Profesores_Asignaturas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorAsignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profesor_id")
    private Long profesorId;

    @Column(name = "asignatura_id")
    private Long asignaturaId;

    // Relaciones opcionales si quieres cargar los objetos relacionados
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", insertable = false, updatable = false)
    private Persona profesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id", insertable = false, updatable = false)
    private Asignatura asignatura;
    
    public Long getProfesorId() {
        return profesorId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

}