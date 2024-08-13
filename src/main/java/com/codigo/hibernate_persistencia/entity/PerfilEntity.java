package com.codigo.hibernate_persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@Getter
@Setter
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private String intereses;
    @OneToOne
    @JoinColumn(name = "usuario_id" ,referencedColumnName = "id")
    //@JsonIgnore -> Ignorar la serialización o carga de este atributo
    @JsonBackReference
    private UsuarioEntity usuario;


}
