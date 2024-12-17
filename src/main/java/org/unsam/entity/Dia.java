package org.unsam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Dias")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

}
