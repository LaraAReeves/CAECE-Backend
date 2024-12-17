package org.unsam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    /*
    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;
     */

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Column(name = "fecha")
    private LocalDate fecha;

    private String turno;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public Aula getAula() {
        return this.aula;
    }

    public String getTurno() {
        return this.turno;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setFecha(LocalDate newFecha) {
        this.fecha = newFecha;
    }

    public void setAula(Aula newAula) {
        this.aula = newAula;
    }

    public void setTurno(String newTurno) {
        this.turno = newTurno;
    }

    public void setProfesor(Profesor newProfesor) {
        this.profesor = newProfesor;
    }
    
}