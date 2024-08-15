package com.codigo.hibernate_persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Transient
    private int totalPosts;

    public void actualizarTotalPost(){
        this.totalPosts = this.posts.size();
    }
}
