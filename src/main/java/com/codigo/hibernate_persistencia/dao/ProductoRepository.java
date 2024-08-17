package com.codigo.hibernate_persistencia.dao;

import com.codigo.hibernate_persistencia.entity.CategoriaEntity;
import com.codigo.hibernate_persistencia.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
    //JPA
    Optional<List<ProductoEntity>> findAllByCategorias(CategoriaEntity categoriaEntity);

    //JQPL
    @Query("SELECT P FROM ProductoEntity P JOIN P.categorias C WHERE C.id= :categoriaid")
    List<ProductoEntity> findByCategorias(@Param("categoriaid") Long categoriaid);

    //SQL NATIVO
    @Query(value = "SELECT p.* FROM productos p " +
            "INNER JOIN producto_categoria pc " +
            "on p.id = pc.producto_id " +
            "where pc.categoria_id = :categoriaid", nativeQuery = true)
    List<ProductoEntity> findByCategoriaNative(@Param("categoriaid") Long categoriaid);
}

