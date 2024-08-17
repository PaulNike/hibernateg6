package com.codigo.hibernate_persistencia.controller;

import com.codigo.hibernate_persistencia.aggregates.ProductoRequest;
import com.codigo.hibernate_persistencia.dao.CategoriaRepository;
import com.codigo.hibernate_persistencia.dao.ProductoRepository;
import com.codigo.hibernate_persistencia.entity.BlogEntity;
import com.codigo.hibernate_persistencia.entity.CategoriaEntity;
import com.codigo.hibernate_persistencia.entity.ProductoEntity;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/productos/v1")
public class ProductoController {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public ProductoController(CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @PostMapping("/categoria/crear")
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaEntity categoriaEntity){
        return new ResponseEntity<>(categoriaRepository.save(categoriaEntity)
                , HttpStatus.CREATED);
    }

    @GetMapping("/categoria/listar")
    public ResponseEntity<?> listarCategoria(){
        return new ResponseEntity<>(categoriaRepository.findAll()
                , HttpStatus.OK);
    }

    @PostMapping("/crear")
    @Transactional
    public ResponseEntity<?> createProducto(@RequestBody ProductoRequest productoRequest){
        ProductoEntity nuevoProducto = new ProductoEntity();
        nuevoProducto.setNombre(productoRequest.getNombre());
        nuevoProducto.setPrecio(productoRequest.getPrecio());

        List<CategoriaEntity> categoriaEntityList =
                categoriaRepository.findAllById(productoRequest.getCategoriasIds());
        Set<CategoriaEntity> categoriaEntity = new HashSet<>(categoriaEntityList);
        nuevoProducto.setCategorias(categoriaEntity);
        return new ResponseEntity<>(productoRepository.save(nuevoProducto)
                , HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarProductos(){
        return new ResponseEntity<>(productoRepository.findAll()
                , HttpStatus.OK);
    }

    @GetMapping("/listarPorCategoria/{id}")
    public ResponseEntity<?> listarProductosPorCategoria(@PathVariable("id")Long id){
        CategoriaEntity categoria = categoriaRepository.findById(id).get();
        return new ResponseEntity<>(productoRepository.findAllByCategorias(categoria)
                , HttpStatus.OK);
    }
    @GetMapping("/listarPorCategoriaJpql/{id}")
    public ResponseEntity<?> listarProductosPorCategoriaJpql(@PathVariable("id")Long id){
        return new ResponseEntity<>(productoRepository.findByCategorias(id)
                , HttpStatus.OK);
    }

    @GetMapping("/listarPorCategoriaNativo/{id}")
    public ResponseEntity<?> listarProductosPorCategoriaNativo(@PathVariable("id")Long id){
        return new ResponseEntity<>(productoRepository.findByCategoriaNative(id)
                , HttpStatus.OK);
    }
}
