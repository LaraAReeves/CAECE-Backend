package org.unsam.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Carreras_Asignaturas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarreraAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "id")
    private Asignatura asignatura;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public Carrera getCarrera() {
        return this.carrera;
    }

    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    public void setCarrera(Carrera newCarr) {
        this.carrera = newCarr;
    }

    public void setAsignatura(Asignatura newAsign) {
        this.asignatura = newAsign;
    }
}
