package com.codigo.hibernate_persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="posts")
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    @ManyToOne
    @JoinColumn(name = "blog_id"
            , referencedColumnName = "id"
            , nullable = false)
    private BlogEntity blog;
}
