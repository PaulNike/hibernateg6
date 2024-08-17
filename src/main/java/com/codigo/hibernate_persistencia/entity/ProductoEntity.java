package com.codigo.hibernate_persistencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonManagedReference
    private Set<CategoriaEntity> categorias;
}
