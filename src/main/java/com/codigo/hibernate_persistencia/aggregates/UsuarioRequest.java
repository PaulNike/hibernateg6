package com.codigo.hibernate_persistencia.aggregates;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    private String username;
    private String password;
    private String cel;
    private Integer estado;
    private String bio;
    private String intereses;
}
