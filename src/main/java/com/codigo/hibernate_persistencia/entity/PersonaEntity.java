package com.codigo.hibernate_persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personas")
@Getter
@Setter
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "per_nombres", nullable = false, length = 255)
    private String nombres;
    @Column(name = "per_apellidos", nullable = false, length = 255)
    private String apellidos;
    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;
    @Column(name = "estado", nullable = false, length = 255)
    private Integer estado;

}
