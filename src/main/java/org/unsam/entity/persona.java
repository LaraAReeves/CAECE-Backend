package org.unsam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Personas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;
}
