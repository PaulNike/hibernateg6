package com.codigo.hibernate_persistencia.aggregates;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductoRequest {
    private String nombre;
    private double precio;
    private Set<Long> categoriasIds;
}
