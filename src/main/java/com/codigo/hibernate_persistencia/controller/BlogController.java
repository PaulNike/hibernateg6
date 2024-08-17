package com.codigo.hibernate_persistencia.controller;

import com.codigo.hibernate_persistencia.dao.BlogRepository;
import com.codigo.hibernate_persistencia.entity.BlogEntity;
import com.codigo.hibernate_persistencia.entity.PostEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/blog/v1")
public class BlogController {
    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createBlog(@RequestBody BlogEntity blog){
        blog.getPosts().forEach(post -> post.setBlog(blog));
        return new ResponseEntity<>(blogRepository.save(blog)
                , HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> buscarBlog(@PathVariable("id") Long id){
        return new ResponseEntity<>(blogRepository.findById(id)
                , HttpStatus.CREATED);
    }

    @GetMapping("/find2/{id}")
    public ResponseEntity<?> buscarblog2(@PathVariable("id") Long id){

        BlogEntity blog = blogRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No hay blogs, con ese id"));

        blog.actualizarTotalPost();
        return new ResponseEntity<>(blog
                , HttpStatus.CREATED);
    }

    @PostMapping("/crearPost/{idBlog}")
    public ResponseEntity<?> createPost(@PathVariable("idBlog")Long idBlog,
                                        @RequestBody PostEntity post){
        BlogEntity blog = blogRepository.findById(idBlog).orElseThrow(
                () -> new RuntimeException("ERROR NO HAY BLOGS CON ESE ID"));
            post.setBlog(blog);
            blog.getPosts().add(post);
            blog.actualizarTotalPost();
            return new ResponseEntity<>(blogRepository.save(blog)
                    , HttpStatus.CREATED);
    }
}
