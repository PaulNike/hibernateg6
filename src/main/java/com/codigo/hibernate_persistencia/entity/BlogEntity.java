package com.codigo.hibernate_persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
@Getter
@Setter
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL
            , fetch = FetchType.LAZY)
    private List<PostEntity> posts = new ArrayList<>();
}
