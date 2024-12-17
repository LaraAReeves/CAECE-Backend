package org.unsam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Horarios_Asignaturas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorarioAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asignaturas_id")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "aulas_id")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "dia_id")
    private Dia dia;

    private String turno;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    public Aula getAula() {
        return this.aula;
    }

    public Dia getDia() {
        return this.dia;
    }

    public String getTurno() {
        return this.turno;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

}
