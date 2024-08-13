package com.codigo.hibernate_persistencia.controller;

import com.codigo.hibernate_persistencia.dao.BlogRepository;
import com.codigo.hibernate_persistencia.entity.BlogEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/v1")
public class BlogController {
    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createBlog(@RequestBody BlogEntity blog){
        return new ResponseEntity<>(blogRepository.save(blog)
                , HttpStatus.CREATED);
    }
}
