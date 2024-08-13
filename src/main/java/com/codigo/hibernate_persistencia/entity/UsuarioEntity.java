package com.codigo.hibernate_persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "cel", nullable = false, length = 9)
    private String cel;
    @Column(name = "estado", nullable = false, length = 1)
    private Integer estado;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL )
    @JsonManagedReference
    private PerfilEntity perfil;




}
