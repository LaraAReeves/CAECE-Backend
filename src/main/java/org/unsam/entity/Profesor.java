package org.unsam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Profesores")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public void setApellido(String newApellido) {
        this.apellido = newApellido;
    }
}
